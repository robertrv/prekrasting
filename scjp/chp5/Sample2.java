public class Sample2 {
	
	public static void main(String[] args) {
		/*
		System.out.println("args: "+ args);
		
		assert args.length > 1;

		for(char c : args[0].toCharArray()) {
			switch (c) {
				case 'a':
					System.out.println("is an a"); 
					break;
				case 'b':
					System.out.println("is a b"); 
					break;
				default:
					System.out.println("is another letter"); 
					break;
			}		
		}
		*/
		int x = 5;
		for (; x  > 4 || x < 3; x ++) {
			if (x == 10000) {
				System.out.println("We found ten thousand !");
			}
			if (x < 5 && x > 0) {
				System.out.println("Less than five: " + x);
			}
		}
		System.out.println("final value: " + x);
	}
}