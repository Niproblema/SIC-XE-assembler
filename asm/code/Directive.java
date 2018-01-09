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
public class Directive extends Node {

    public int value;
    public String symbol;

    public Directive(mnemonics.Mnemonic mD, int value) {
        super(mD);
        this.value = value;
    }

    public Directive(mnemonics.Mnemonic mD, String symbol) {
        super(mD);
        this.symbol = symbol;
    }

        @Override
    public void resolve(Code code) {

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
    public int length() {
        return 0;
    }

    @Override
    public String toString() {
        return mnemonic.toString() + " " + (value != 0 ? Integer.toString(value): "");
    }

    /// OPCodes for Directive
    public static final int NOBASE = -1;
    public static final int LTORG = -1;
    public static final int START = -1;
    public static final int END = -1;
    public static final int BASE = -1;
    public static final int EQU = -1;
    public static final int ORG = -1;
}
