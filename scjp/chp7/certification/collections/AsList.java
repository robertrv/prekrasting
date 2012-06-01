package certification.collections;

import java.util.Arrays;
import java.util.List;

public class AsList {
	public static void main(String[] args) {
		String sa[] = { "one", "two", "three", "four" };
		List<String> sList = Arrays.asList(sa);

		printDebug(sa, sList);
		
		/*
		 * Illegal / Unsupported ... returned from Arrays.asList is immutable
		sList.remove(sList.size()-1);
		printDebug(sa, sList);
		
		sa[0] = "Primero";

		printDebug(sa, sList);
		 */
	}

	private static void printDebug(String[] sa, List<String> sList) {
		l("array size: " + sa.length);
		for (String string : sa) {
			System.out.print("\t"+string);
		}

		l("list size: " + sList.size());
		for (String string : sList) {
			System.out.print("\t"+string);
		}
	}

	private static void l(String string) {
		System.out.println(string);
	}

}
