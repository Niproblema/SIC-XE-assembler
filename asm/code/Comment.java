package code;

/**
 * Podporni razred za predmet Sistemska programska oprema.
 * @author jure
 */
public class Comment extends Node {

	public Comment(String comment) {
		super(null);
		setComment(comment);
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

}
