package certification;

public class Widening {
	
	public void go(short arg) {
		System.out.println("double " + arg);
	}
	
	public static void main(String[] args) {
		Widening instance = new Widening();
		//instance.go(5);
		int ouch = 3;
		//for (int ouch=3; ouch<6; ouch++) ;
		
	}
}