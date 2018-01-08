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
public class Storage extends Node {

    public int value;
    public String symbol;
    public byte[] data;

    public Storage(mnemonics.Mnemonic mD, byte[] data) {
        super(mD);
        this.data = data;
    }

    public Storage(mnemonics.Mnemonic mD, int dataL) {
        super(mD);
        this.data = new byte[dataL];
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static final int RESB = -1;
    public static final int RESW = -1;
    public static final int BYTE = -1;
    public static final int WORD = -1;
}
