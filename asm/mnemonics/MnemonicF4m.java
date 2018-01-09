/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mnemonics;

import code.Code;
import code.Directive;
import code.Flags;
import code.InstructionF3;
import code.InstructionF4;
import code.Node;
import parsing.Parser;
import parsing.SyntaxError;

/**
 *
 * @author jan
 */
public class MnemonicF4m extends Mnemonic {

    public MnemonicF4m(String mnemonic, int opcode, String hint, String desc) {
        super(mnemonic, opcode, hint, desc);
    }

    @Override
    public Node parse(Parser parser) throws SyntaxError {
        parser.lexer.skipWhitespace();
        Flags fla = new Flags(1, 1, 0, 0, 0, 0);
        if (parser.lexer.advanceIf('#')) {
            fla.i = 1;
            fla.n = 0;
        } else if (parser.lexer.advanceIf('@')) {
            fla.i = 0;
            fla.n = 1;
        }
        // number
        if (Character.isDigit(parser.lexer.peek())) {
            return new InstructionF4(this, parser.parseNumber(0, Code.MAX_ADDR), fla);
        } // symbol
        else if (Character.isLetter(parser.lexer.peek())) {
            return new InstructionF4(this, parser.parseSymbol(), fla);
        } // otherwise: error
        else {
            throw new SyntaxError(String.format("Invalid character '%c", parser.lexer.peek()), parser.lexer.row, parser.lexer.col);
        }
    }
}
