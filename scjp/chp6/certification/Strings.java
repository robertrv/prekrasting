package certification;

import java.util.ArrayList;

public class Strings {
	
	public static void main(String[] args) {
		String s = "a	\t";
		
		l(s.trim()+ " size: "+s.trim().length());
		StringBuilder builder = new StringBuilder("something");
		builder.append(new ArrayList<String>());
		StringBuilder theOtherBuilder = builder.insert(4, "blabla");
		builder.append(". Something more");
		l(builder);
		l(theOtherBuilder);
	}
	
	private static void l(Object arg){
		System.out.println(arg);
	}

}
