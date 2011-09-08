class Sample {
	
	public 
	static void main(String[] args) {
		int b = 3;
		System.out.println("this is b:" + b);
		System.out.println("this is b++:" + b++ + " another time: "+ (b = ++b));
		System.out.println("args[0]: " + args[0]);
	}
}