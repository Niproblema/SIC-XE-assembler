
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import code.Code;
import code.SemanticError;
import java.io.FileWriter;
import parsing.Parser;
import parsing.SyntaxError;

/**
 * Podporni razred za predmet Sistemska programska oprema.
 *
 * @author jure
 */
public class Asm {

    public static String readFile(File file) {
        byte[] buf = new byte[(int) file.length()];
        try {
            InputStream s = new FileInputStream(file);
            try {
                s.read(buf);
            } finally {
                s.close();
            }
        } catch (IOException e) {
            return "";
        }
        return new String(buf);
    }

    public static void writeFile(String fileName, String Content) {
        try{
            FileWriter wOut = new FileWriter(fileName);
            wOut.write(Content);
            wOut.flush();
            wOut.close();
        }catch(Exception e){
            System.out.println(e.toString());   
        }        
    }

    public static void main(String[] args) {
        String input;
        // TODO
        input = readFile(new File(args[0]));
        Parser parser = new Parser();
        Code code;
        try {
            code = parser.parse(input);
            code.resolve();
            code.print();

            //Make some Files
            String bName = getFileBasename(args[0]);

            writeFile(bName + ".log", code.dumpSymbols());
            writeFile(bName+".lst",code.dumpCode());
            writeFile(bName+".obj",code.emitText());
        } catch (SyntaxError e) {
            System.err.println(e);
            System.exit(1);
            return;
        } catch (SemanticError e) {
            System.err.println(e);
            System.exit(1);
            return;
        }
    }

    public static String getFileBasename(String filename) {
        int pos = filename.lastIndexOf(".");
        return pos > 0 ? filename.substring(0, pos) : filename;
    }

}
