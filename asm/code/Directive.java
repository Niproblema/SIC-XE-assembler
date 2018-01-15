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

    boolean startActivated = false;

    @Override
    public void activate(Code code) {
        switch (mnemonic.opcode) {
            case Directive.START:
                startActivated = true;
                code.programName = label;
                code.startProgramPtr = value;
                code.PCptr = value;
                code.locPtr = value;
                break;
            case Directive.END:
                break;
            case Directive.ORG:
                if (!startActivated) {
                    startActivated = true;
                    code.programName = label;
                    code.startProgramPtr = value;
                    code.PCptr = value;
                    code.locPtr = value;
                }

                break;
            case Directive.EQU:
                int val = symbol == null ? value : code.locPtr; //Works with * only 
                value = val;
                code.defineSymbol(this.label, val);
                break;

        }
        super.activate(code); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resolve(Code code) {
        if (symbol != null) {
            value = code.resolveSymbol(symbol);
            symbol = null;
        }
        switch (mnemonic.opcode) {
            case Directive.START:
                code.programName = label;
                code.startProgramPtr = value;
                code.PCptr = value;
                code.locPtr = value;
                break;
            case Directive.END:
                break;
            case Directive.BASE:
                code.regB = value;
                break;
            case Directive.NOBASE:
                code.regB = 0;
                break;
            case Directive.ORG:
                code.PCptr = value;
                code.locPtr = value;
                break;
            case Directive.EQU:
                break;
        }
    }

    @Override
    public void enter(Code code) {
        if (mnemonic.opcode == Directive.ORG) {
            code.PCptr = value;
            code.locPtr = value;
        }
    }

    @Override
    public byte[] emitCode() {
        return new byte[0];
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
        String rtn = String.format("%-6s   %-6s   %-6s", (label != null ? label : " "), this.mnemonic.toString(), (symbol != null ? symbol : value));
        return rtn;
    }

    /// OPCodes for Directive
    public static final int NOBASE = 9001;
    public static final int LTORG = 9002;
    public static final int START = 9003;
    public static final int END = 9004;
    public static final int BASE = 9005;
    public static final int EQU = 9006;
    public static final int ORG = 9007;
}
