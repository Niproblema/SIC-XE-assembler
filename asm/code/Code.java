package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Podporni razred za predmet Sistemska programska oprema.
 * @author jure
 */
public class Code {
        protected LinkedList<Node> program;
        //TODO: Slovar simbolov ?? 
        Map<String, Integer> symbols;
        public static int MAX_WORD = (int)Math.pow(2, 24); //TODO: ?value
	
        
        public Code(){
            program = new LinkedList<>();
            symbols = new HashMap<>();  //TODO: ??
        }
        
        public void append(Node nodeToAdd){
            program.add(nodeToAdd);
        }
//        public void defineSymbol(sym, val){
//            
//        }
//        public void resolveSymbol(sym){
//            
//        }
        
        public byte[] emitCode(){
            return new byte[0];
        }
        public String emitText(){
            return new String();
        }
        public String dumpCode(){
            return new String();
        }
        public String dumpSymbols(){
            return new String();
        }       
}
