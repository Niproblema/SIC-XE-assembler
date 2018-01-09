package code;

import java.text.Format;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Podporni razred za predmet Sistemska programska oprema.
 *
 * @author jure
 */
public class Code {

    public String programName = "";
    private LinkedList<Node> program;
    public int PCptr, locPtr, regB;
    public int startProgramPtr = 0;
    public int endProgramPtr;
    public HashMap<String, Integer> symbols;
    public byte[] rawCode;
    public static int MAX_ADDR = (int) Math.pow(2, 20); //TODO: ?value
    public static int MAX_WORD = MAX_ADDR - 1; //TODO: ?value

    public Code() {
        program = new LinkedList<>();
        symbols = new HashMap<>();
        PCptr = 0;
        locPtr = 0;
    }

    public void append(Node nodeToAdd) {
        program.add(nodeToAdd);
        PCptr += nodeToAdd.length();
        nodeToAdd.activate(this);
        locPtr = PCptr;
    }

    public void defineSymbol(String sym, int val) {
        symbols.put(sym, val);
    }

    public int resolveSymbol(String sym) {
        return symbols.get(sym);
    }

    private void begin() {
        PCptr = startProgramPtr;
        locPtr = startProgramPtr;
        regB = -1;
    }

    private void end() {
        endProgramPtr = PCptr;
    }

    public void resolve() throws SemanticError {
        begin();
        for (Node node : program) {
            node.enter(this);
            node.resolve(this);
            node.leave(this);
        }
        end();
    }

    public void print() {
        for (Node node : program) {
            System.out.println(node.toString());
        }
    }

    public byte[] emitCode() {
        rawCode = new byte[PCptr];
        begin();
        for (Node no : program) {
            no.enter(this);
            no.emitCode(rawCode, PCptr);
            no.leave(this);
        }
        end();

        return rawCode;
    }

    public String emitText() {
        StringBuffer buf = new StringBuffer();
        buf.append(String.format("H%-6s%06X%06X\n", programName, startProgramPtr, (endProgramPtr - startProgramPtr)));

        int charCounter = 0;
        StringBuffer toWrite = new StringBuffer();
        begin();
        int start = PCptr;
        for (Node no : program) {
            no.enter(this);
            String newText = no.emitText();
            if (charCounter + newText.length() > 60) {
                buf.append(String.format("T%06X%02X%s\n", start, charCounter/2, toWrite.toString()));
                toWrite = new StringBuffer();
                charCounter = 0;
                start = locPtr;
            }
            toWrite.append(newText);
            charCounter += newText.length();

            no.leave(this);
        }
        if(charCounter != 0){
           buf.append(String.format("T%06X%02X%s\n", start, charCounter/2, toWrite.toString())); 
        }
        end();
        
        buf.append(String.format("E%06X\n",startProgramPtr ));
        return buf.toString();
    }

    //Listing datoteka: Lokacija, surova koda, ukaz
    public String dumpCode() {
        StringBuffer buf = new StringBuffer();
        begin();
        for (Node no : program) {
            no.enter(this);
            String obj = no.emitText();
            String ukaz = no.toString();
            buf.append(String.format("%-5s   %-8s   %s\n", Opcode.byteToHex(new byte[]{(byte)locPtr}), obj, ukaz));
            no.leave(this);
        }
        end();
        
        return buf.toString();
    }

    public String dumpSymbols() {
        String out = new String();

        for (Map.Entry<String, Integer> en : symbols.entrySet()) {
            out += en.getKey() + " " + en.getValue().toString() + "\n";
        }
        return out;
    }
}
