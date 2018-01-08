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
public class InstructionF2 extends Node {
    public int value;
    public int reg1, reg2;
    public String symbol;

    public InstructionF2(mnemonics.Mnemonic mD, int reg1, int reg2) {
        super(mD);
        this.reg1 = reg1;
        this.reg2 = reg2;
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
        return 2;
    }
    
}
