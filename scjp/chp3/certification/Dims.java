package certification;

public class Dims {
	
	public static void main(String[] args) {
		int[][] a = {{1,2},{3,4}};
		int[] b = (int[]) a[1];
		Object o1 = a;
		int[][] a2 = (int[][]) o1;
		//int[] b2 = (int[]) o1;
		System.out.println(b[1]);
		Fizz f1 = new Fizz();
		Fizz f2 = f1;
		System.out.println(f1 == f2);
	}
}
class Fizz {
	int x = 5;
}
