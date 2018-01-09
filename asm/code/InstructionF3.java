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

    public int value, ni;
    public String symbol;
    public Flags flags;

    public InstructionF3(mnemonics.Mnemonic mD, int value, Flags fla) {
        super(mD);
        this.flags = fla;
        this.value = value;
        this.ni = ni;
    }

    public InstructionF3(mnemonics.Mnemonic mD, String symbol, Flags fla) {
        super(mD);
        this.flags = fla;
        this.symbol = symbol;
        this.ni = ni;
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
        byte[] rtn = new byte[3];
        rtn[0] = (byte)(mnemonic.opcode & 0xFC | ((flags.n << 1) & 0x02) | (flags.i & 0x01));
        if(flags.n == 0 && flags.i == 0){
            rtn[1] = (byte)(((flags.x << 7) & 0x80) | ((value >> 8)& 0x7F));
        }else
        rtn[1] = (byte)(((flags.x << 7) & 0x80) | ((flags.b << 6) & 0x40) | ((flags.p << 5) & 0x20) | ((flags.e << 4) & 0x10) | ((value >> 8)& 0x0F));
        
        rtn[2] = (byte)(value & 0xFF);
        
        return rtn;
    }

    @Override
    public void emitCode(byte[] data, int pos) {
        byte[] in = emitCode();
        for(int i = 0; i < this.length(); i++){
            data[pos+i] = in[i];
        }
    }

    @Override
    public int length() {
        return 3;
    }

    @Override
    public String toString() {
        String vpis = "";
        if(ni == 1){
            vpis = "#";
        }else if(ni == 2){
            vpis = "@";
        }
        
        return mnemonic.toString() + " " + vpis+(symbol != null ? symbol : (value != -1 ? Integer.toString(value) : ""));
    }
}
