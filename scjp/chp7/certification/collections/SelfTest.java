package certification.collections;

class Turtle {
	int size;
	public Turtle(int s) { size = s; }
	public boolean equasl(Object o ) {return this.size == ((Turtle)o).size;}
	@Override
	public int hashCode() {
		int d = (size/5);
		return d;
	}
}

public class SelfTest {
	

}
