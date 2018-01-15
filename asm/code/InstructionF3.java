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
    public Flags flags;

    public InstructionF3(mnemonics.Mnemonic mD, int value, Flags fla) {
        super(mD);
        this.flags = fla;
        this.value = value;
    }

    public InstructionF3(mnemonics.Mnemonic mD, String symbol, Flags fla) {
        super(mD);
        this.flags = fla;
        this.symbol = symbol;
    }

    @Override
    public void resolve(Code code) {
        if (mnemonic.opcode != Opcode.RSUB) {
            if (symbol != null) {
                value = code.resolveSymbol(symbol);
            }
            if (flags.i != 1 || flags.n != 0 || symbol != null) {
                int odmik = value - code.PCptr;
                int bazniOdmik = value - code.regB;

                flags.p = flags.b == 0 && odmik >= -2048 && odmik <= 2047 ? 1 : 0;
                flags.b = flags.p == 0 && code.regB > 0 && bazniOdmik >= 0 && bazniOdmik <= 4095 ? 1 : 0;

                if (flags.b == 0 && flags.p == 0) {
                    if (value < 0 || value > 4095) {
                        //Error
                        System.out.println("Error, wrong address");
                    }
                } else if (flags.b == 1) {
                    value = bazniOdmik;
                } else if (flags.p == 1) {
                    value = odmik;
                }
            }
        }
        if (flags.b == 0 && flags.p == 0 && symbol != null) {
            code.relocations.add(new Modification(code.locPtr + 1, (this.length() - 1) * 2 - 1));
        }
    }

    @Override
    public byte[] emitCode() {
        byte[] rtn = new byte[3];
        rtn[0] = (byte) (mnemonic.opcode & 0xFC | ((flags.n << 1) & 0x02) | (flags.i & 0x01));
        if (flags.n == 0 && flags.i == 0) {
            rtn[1] = (byte) (((flags.x << 7) & 0x80) | ((value >> 8) & 0x7F));
        } else {
            rtn[1] = (byte) (((flags.x << 7) & 0x80) | ((flags.b << 6) & 0x40) | ((flags.p << 5) & 0x20) | ((flags.e << 4) & 0x10) | ((value >> 8) & 0x0F));
        }

        rtn[2] = (byte) (value & 0xFF);

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
        return 3;
    }

    @Override
    public String toString() {
        String vpis = "";
        if (flags.i == 1 && flags.n == 0) {
            vpis = "#";
        } else if (flags.n == 1 && flags.i == 0) {
            vpis = "@";
        }

        //return mnemonic.toString() + " " + vpis + (symbol != null ? symbol : (value != -1 ? Integer.toString(value) : ""));
        String rtn = String.format("%-6s   %-6s   %-6s", (label != null ? label : " "), this.mnemonic.toString(), vpis + (symbol != null ? symbol : value));
        return rtn;
    }
}
