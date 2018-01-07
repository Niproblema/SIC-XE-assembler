package mnemonics;

import code.Code;
import code.Directive;
import code.Node;
import parsing.Parser;
import parsing.SyntaxError;

/**
 * Directive with one numeric operand. Podporni razred za predmet Sistemska
 * programska oprema.
 *
 * @author jure
 */
public class MnemonicDn extends Mnemonic {

    public MnemonicDn(String mnemonic, int opcode, String hint, String desc) {
        super(mnemonic, opcode, hint, desc);
    }

    @Override
    public Node parse(Parser parser) throws SyntaxError {
        // number
        if (Character.isDigit(parser.lexer.peek())) {
            return new Directive(this, parser.parseNumber(0, Code.MAX_ADDR));
        } // symbol
//        else if (Character.isLetter(parser.lexer.peek())) {       //TODO: Why Letter when it's digit operand?
//            return new Directive(this, parser.parseSymbol());
//        } // otherwise: error
        else {
            throw new SyntaxError(String.format("Invalid character '%c", parser.lexer.peek()), parser.lexer.row, parser.lexer.col);
        }
    }

    @Override
    public String operandToString(Node instruction) {
        Directive i = ((Directive) instruction);
        return i.symbol != null ? i.symbol : Integer.toString(i.value);
    }

}
