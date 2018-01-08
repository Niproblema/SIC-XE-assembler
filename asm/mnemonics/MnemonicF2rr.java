/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mnemonics;

import code.Code;
import code.Directive;
import code.InstructionF2;
import code.Node;
import parsing.Parser;
import parsing.SyntaxError;

/**
 *
 * @author jan
 */
public class MnemonicF2rr extends Mnemonic {

    public MnemonicF2rr(String mnemonic, int opcode, String hint, String desc) {
        super(mnemonic, opcode, hint, desc);
    }

    @Override
    public Node parse(Parser parser) throws SyntaxError {
        int reg = parser.parseRegister();
        parser.parseComma();
        int reg2 = parser.parseRegister();
        return new InstructionF2(this, reg, reg2);
    }
    
}
