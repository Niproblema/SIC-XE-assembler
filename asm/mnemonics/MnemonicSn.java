/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mnemonics;

import code.Code;
import code.Directive;
import code.Node;
import code.Storage;
import parsing.Parser;
import parsing.SyntaxError;

/**
 *
 * @author jan
 */
public class MnemonicSn extends Mnemonic {

    public MnemonicSn(String mnemonic, int opcode, String hint, String desc) {
        super(mnemonic, opcode, hint, desc);
    }

    @Override
    public Node parse(Parser parser) throws SyntaxError {
        byte[] data = parser.parseData();
        int val = 0;
        try{
            for(byte b : data){
                val += b * (opcode == Storage.RESW ? 3 : 1);
            }
        }catch(Exception e){
            System.out.println("Error parsing MNSn, "+e.toString());
        }      
        return new Storage(this, val);
    }   
}
