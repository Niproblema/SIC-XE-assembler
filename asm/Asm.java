

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import code.Code;
import code.SemanticError;
import parsing.Parser;
import parsing.SyntaxError;

/**
 * Podporni razred za predmet Sistemska programska oprema.
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


	public static void main(String[] args) {
		String input;

		// TODO
		//input = readFile(new File(args[0]));
		input = "    START 42\n    END zacetek";

		Parser parser = new Parser();
		Code code;
		try {
			code = parser.parse(input);
			//code.print(); //TODO: 
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

}