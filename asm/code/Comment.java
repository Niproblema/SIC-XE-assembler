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
    public void resolve(Code code) {   
        //Nuthing
    }   

    @Override
    public byte[] emitCode() {
       return null;
    }

    @Override
    public void emitCode(byte[] data, int pos) {
        //Nuthing
    }

    @Override
    public int length() {
        return 0;
    }

}
