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
        byte[] rtn = new byte[1];
        rtn[0] = (byte) (mnemonic.opcode);
        return rtn;
    }

    @Override
    public void emitCode(byte[] data, int pos) {
        byte[] in = emitCode();
        for (int i = 0; i < this.length(); i++) {
            data[pos + i] = in[i];
        }
    }

    @Override
    public int length() {
        return 1;
    }

}
