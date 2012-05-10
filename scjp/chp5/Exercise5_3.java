public class Exercise5_3 {
	
	public static void doException() {
		int test = 5 / 0;
	}
	
	public static String reverse(String s) {
		if (s.length() == 0) {
			throw new IllegalStateException();
		}
		String reverseStr = "";
		for (int i=s.length()-1; i>=0;--i){
			reverseStr += s.charAt(i);
		}
		return reverseStr;
	}
	
	public static void main(String[] args) {
		try {
			l("result: " + reverse(args[0]));
		} catch (Exception exception) {
			l("Error at main !");
			exception.printStackTrace();
		} finally {
			l("main finished");
		}
	}
	
	public static void l(String arg){
		System.out.println(arg);
	}
}