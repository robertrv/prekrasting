public class Exercise5_3 {
	
	public static void doException() {
		int test = 5 / 0;
	}
	
	public static void main(String[] args) {
		try {
			doException();
		} catch (Exception exception) {
			
		} finally {
			
		}
	}
}