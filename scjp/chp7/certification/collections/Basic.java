package certification.collections;

import java.util.ArrayList;

public class Basic {

	public static void main(String[] args) {
		ArrayList<String> stuff = new ArrayList<String>();
		stuff.add("Denver");
		stuff.add("Boulder");
		stuff.add("Vail");
		stuff.add("Aspen");
		stuff.add("Telluride");
		System.out.println("unsorted: " + stuff);
		java.util.Collections.sort(stuff);
		System.out.println("sorted: " + stuff);
	}
}
