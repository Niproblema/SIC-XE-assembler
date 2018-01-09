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
    public boolean res = false;
    public int volumneRes = 0;

    public Storage(mnemonics.Mnemonic mD, byte[] data) {
        super(mD);
        res = false;
        this.data = data;
    }

    public Storage(mnemonics.Mnemonic mD, int dataL) {
        super(mD);
        res = true;
        this.volumneRes = dataL;
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
        return (res? new byte[this.length()] : this.data);
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
        return (res ? volumneRes : data.length);
    }

    //TODO: finish this maybe
//    @Override
//    public String toString() {        
//    //    return mnemonic.toString() + " " + vpis+(symbol != null ? symbol : Integer.toString(value));
//    }
    public static final int RESB = -1;
    public static final int RESW = -3;
    public static final int BYTE = -2;
    public static final int WORD = -4;
}
