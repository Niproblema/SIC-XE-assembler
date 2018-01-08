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
public class MnemonicF2n extends Mnemonic {

    public MnemonicF2n(String mnemonic, int opcode, String hint, String desc) {
        super(mnemonic, opcode, hint, desc);
    }

    @Override
    public Node parse(Parser parser) throws SyntaxError {
        // number
        if (Character.isDigit(parser.lexer.peek())) {
            return new InstructionF2(this, parser.parseNumber(0, 15), -1);
        } // otherwise: error
        else {
            throw new SyntaxError(String.format("Invalid character '%c", parser.lexer.peek()), parser.lexer.row, parser.lexer.col);
        }
    }

}
