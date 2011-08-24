package sample;

public class Alpha {
	String name = "hola";
	
}

class Beta extends Alpha {
	String name = "adios";
	static void sifter(Alpha... b1) {
		System.out.println("multiple alphas");
	}
	static void sifter(Alpha b1) {
		System.out.println("just one ");		
	}
	
	public static void main(String[] args) {
		Alpha[] a = new Alpha[2];
		for(Alpha aa : a) {
			System.out.println("this is the name "+ aa.name);
		}
//		sifter();
//		sifter(a, a);
//		sifter(a);
	} 
}