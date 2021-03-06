package mnemonics;

//import code.Directive;
import code.Directive;
import code.Node;
import parsing.Parser;
import parsing.SyntaxError;

/**
 * Directive without operands. Podporni razred za predmet Sistemska programska
 * oprema.
 *
 * @author jure
 */
public class MnemonicD extends Mnemonic {

    public MnemonicD(String mnemonic, int opcode, String hint, String desc) {
        super(mnemonic, opcode, hint, desc);
    }

    @Override
    public Node parse(Parser parser) throws SyntaxError {
        if(opcode == Directive.EQU){
            
        }
        return new Directive(this, 0);
    }

}
