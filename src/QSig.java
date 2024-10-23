

/*
 * This class represents a state (integer), alphabet (Sig) pair
 * Our NFA class uses this as keys for transitions to new states
 */
public class QSig{

	Integer q;
	Character sig;

	public QSig(Integer q, Character sig){
		this.q = q;
		this.sig = sig;
	}

	public boolean equals(Object o){
		QSig other = (QSig)o;
		return other.q == this.q && other.sig.equals(this.sig);
	}

	public int hashCode(){
		/* Not the best but will work fine for this project */
		return this.q.hashCode() + this.sig.hashCode();
	}

	public String toString(){
		return "(" + q + ", " + sig + ")";
	}
}