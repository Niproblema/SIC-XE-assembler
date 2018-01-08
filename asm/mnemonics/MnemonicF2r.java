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
public class MnemonicF2r extends Mnemonic {

    public MnemonicF2r(String mnemonic, int opcode, String hint, String desc) {
        super(mnemonic, opcode, hint, desc);
    }

    @Override
    public Node parse(Parser parser) throws SyntaxError {
        try {
            return new InstructionF2(this, parser.parseRegister(), -1);
        } catch (Exception e) {
            throw new SyntaxError(String.format("Invalid character '%c", parser.lexer.peek()), parser.lexer.row, parser.lexer.col);
        }
    }

}
