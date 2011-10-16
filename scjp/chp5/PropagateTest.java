public class PropagateTest {
	
	String reverse(String ordered) throws Exception {
		if (ordered.length() == 0) {
			throw new Exception("Parameter cannot be emtpy !");
		}
		String reverseStr = "";
		for (int i = ordered.length() -1 ; i >= 0 ; i--) {
			reverseStr += ordered.charAt(i);
		}
		return reverseStr;
	}
	
	public static void main(String[] args) {
		try {
			PropagateTest p = new PropagateTest();
			System.out.println("Result of propagate("+args[0]+"): " + p.reverse(args[0]));
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			System.out.println("This class has ended !");
		}
	}
}