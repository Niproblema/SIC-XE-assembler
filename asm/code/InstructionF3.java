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
public class InstructionF3 extends Node {

    public int value;
    public String symbol;

    public InstructionF3(mnemonics.Mnemonic mD, int value) {
        super(mD);
        this.value = value;
    }

    public InstructionF3(mnemonics.Mnemonic mD, String symbol) {
        super(mD);
        this.symbol = symbol;
    }

    @Override
    public byte[] emitCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void emitCode(byte[] data, int pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void emitText(StringBuffer buff) {
        super.emitText(buff); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int length() {
        return 3;
    }
}
