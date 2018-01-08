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

    @Override
    public String toString() {
        return comment;
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
    
   
    /// OPCodes for Directive
    public static final int NOBASE = -1;
    public static final int LTORG = -1;
    public static final int START = -1;
    public static final int END = -1;
    public static final int BASE = -1;
    public static final int EQU = -1;
    public static final int ORG = -1;
}
