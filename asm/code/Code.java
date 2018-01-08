package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Podporni razred za predmet Sistemska programska oprema.
 *
 * @author jure
 */
public class Code {

    private String programName;
    private LinkedList<Node> program;
    public int PCptr, locPtr, regB;
    public int startProgramPtr = 0;
    public HashMap<String, Integer> symbols;
    public static int MAX_ADDR = (int) Math.pow(2, 20); //TODO: ?value
    public static int MAX_WORD = MAX_ADDR-1; //TODO: ?value

    public Code() {
        program = new LinkedList<>();
        symbols = new HashMap<>();
    }

    public void append(Node nodeToAdd) {
        program.add(nodeToAdd);
    }
//        public void defineSymbol(sym, val){
//            
//        }
//        public void resolveSymbol(sym){
//            
//        }

    private void begin() {
        PCptr = startProgramPtr;
        locPtr = startProgramPtr;
        regB = -1;
    }

    private void end() {

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

    public byte[] emitCode() {
        return new byte[0];
    }

    public String emitText() {
        return new String();
    }

    public String dumpCode() {
        return new String();
    }

    public String dumpSymbols() {
        return new String();
    }
}
