class Sample {
	
	public static void main(String[] args) {
		int b = 3;
		System.out.println("this is b:" + b);
		System.out.println("this is b++:" + b++ + " another time: "+ (b = ++b));
		l("5.0 == 5L "+ (5.0 == 5L));
		l("5.0 == 5 "+ (5.0 == 5));
		l("5.1f == 5.1d "+ (5.1f == 5.1));
		String[] bb = {};
		l("test " + ('a' + 0));
		int x = 1;
		int y = 2;
		if ((x++ > 1) && (y++ < 2)) {
			l("inside");
		}
		l("value of y: "+y);
		byte bin1 = Byte.parseByte("1010", 2);
		byte bin2 = Byte.parseByte("0111", 2);
		
		l("bin1&bin2: "+ Byte.toString((byte)(bin1&bin2)));
		l("bin1&bin2: "+ (bin1|bin2));
		l("bin1&bin2: "+ (bin1^bin2));
		l("condition: " + (97f == 'a'));
		boolean bo = true;
		l("cond: "+ (bo = true));
	}
	
	public static void l(String arg) {
		System.out.println(arg);
	}
}