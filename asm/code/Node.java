package code;

import mnemonics.Mnemonic;

/**
 * Abstract class Node.
 * Includes label, mnemonic and comment.
 * Podporni razred za predmet Sistemska programska oprema.
 * @author jure
 */
public abstract class Node {

	protected String label;
	protected Mnemonic mnemonic;
	protected String comment;

	public Node(Mnemonic mnemonic) {
		this.mnemonic = mnemonic;
	}
        
        public void enter(Code code){
            code.PCptr += this.length();
        }
        public abstract void resolve(Code code);
        
        public void leave(Code code){
            code.locPtr = code.PCptr;
        }
        
        public void activate(Code code){
            if(label != null){
                code.defineSymbol(label, code.locPtr);
            }
        }
                
        public abstract int length();
        
        public abstract void emitCode(byte[] data, int pos);
        
        public abstract byte[] emitCode();     
        
        public String emitText(){
            return Opcode.byteToHex(emitCode());
        }

	public String getLabel() {
		return label == null ? "" : label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Return comment as a string.
	 */
	public String getComment() {
		return comment == null ? "" : comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Return string representation of the node.
	 * Label and comment are not included.
	 */
	@Override
	public String toString() {
            
		return mnemonic.toString() + " " + operandToString();
	}

	public String operandToString() {
		return mnemonic.operandToString(this);
	}

}
