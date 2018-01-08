/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mnemonics;

import code.Code;
import code.Directive;
import code.InstructionF3;
import code.Node;
import parsing.Parser;
import parsing.SyntaxError;

/**
 *
 * @author jan
 */
public class MnemonicF3m extends Mnemonic {

    public MnemonicF3m(String mnemonic, int opcode, String hint, String desc) {
        super(mnemonic, opcode, hint, desc);
    }
    
    @Override
    public Node parse(Parser parser) throws SyntaxError {
        // number
        if (Character.isDigit(parser.lexer.peek())) {
            return new InstructionF3(this, parser.parseNumber(0, Code.MAX_ADDR));
        } // symbol
        else if (Character.isLetter(parser.lexer.peek())) {     
            return new InstructionF3(this, parser.parseSymbol());
        } // otherwise: error
        else {
            throw new SyntaxError(String.format("Invalid character '%c", parser.lexer.peek()), parser.lexer.row, parser.lexer.col);
        }
    }
    
}
