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
public class MnemonicSd extends Mnemonic {

    public MnemonicSd(String mnemonic, int opcode, String hint, String desc) {
        super(mnemonic, opcode, hint, desc);
    }

    @Override
    public Node parse(Parser parser) throws SyntaxError {
        byte[] data = parser.parseData();
        if(opcode == Storage.BYTE && data.length == 3){
            byte k = data[2];
            data = new byte[1];
            data[0] = k;
        }else if(opcode == Storage.WORD && data.length % 3 != 0){
            int f = data.length % 3;
            byte[] nData = new byte[data.length + (3-f)];
            for(int i = 0; i < data.length; i++){
               nData[i] = data[i];                
            }
            data = nData;
        }
        return new Storage(this,data);
    }
    
}
