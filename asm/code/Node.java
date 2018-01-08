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
        public void resolve(Code code){
            //resolves symbol
        }
        public void leave(Code code){
            
        }
        
        public void activate(Code code){
            //if(symbol.value != null)
            //code.symbols.put(symbol.string, symbol.value);
        }
                
        public abstract int length();
        
        public abstract void emitCode(byte[] data, int pos);
        
        public abstract byte[] emitCode();     
        
        public void emitText(StringBuffer buff){
            //buff.append(emitCode); //TODO: Append string < hex < byte[]
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
