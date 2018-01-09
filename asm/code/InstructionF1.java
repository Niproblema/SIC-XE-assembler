/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

/**
 *
 * @author jan
 */
public class InstructionF1 extends Node {

    public int value;
    public String symbol;

    public InstructionF1(mnemonics.Mnemonic mD, int value) {
        super(mD);
        this.value = value;
    }

    @Override
    public void resolve(Code code) {
        if (symbol != null) {
            value = code.resolveSymbol(symbol);
            symbol = null;
        }
    }

    @Override
    public byte[] emitCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void emitCode(byte[] data, int pos) {
        byte[] in = emitCode();
        for(int i = 0; i < this.length(); i++){
            data[pos+i] = in[i];
        }
    }

    @Override
    public void emitText(StringBuffer buff) {
        super.emitText(buff); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int length() {
        return 1;
    }

    @Override
    public String toString() {
        return mnemonic.toString();
    }
}
