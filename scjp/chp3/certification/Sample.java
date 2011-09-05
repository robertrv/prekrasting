package certification;

public class Sample {
	
	
	
	public static void main(String[] args) {
		byte bb = (byte)2700;
		System.out.println(bb);
		float f = 234.56f;
		short s = (short)f;
		byte a  = 3;
		byte b = 8;
		byte c = (byte) (a + b);
		s = (byte) 128;
		System.out.println("s: " + s);
		
		int [][] array = new int [1][1];
		System.out.println(array[0][0]);
		String [] sa = new String[]{"", null, ""};
		int[] aaa = {'a', 4, 03, 0x4, -3};
		int[] ints = new int[]{1,2,3,};
		char[] chars = {'2','c',0};
		
		Integer i3 = 1000;
		Integer i4 = 1000;
		if (i3 == i4) System.out.println("== ok");
		if (i3.equals(i4)) System.out.println("are equals");
		Sample ss = new Sample();
		ss.doStuff(Long.valueOf("2"));
		byte b2 = 5;
		ss.doStuff(b2);
	}
	
	public void doStuff(Long param) {
		System.out.println("first: " + param);
	}
	public void doStuff(double param) {
		System.out.println("second: " + param);
	}
}