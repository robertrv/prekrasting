package certification.collections;

import java.util.Arrays;
import java.util.Comparator;

public class SearchObjArray {

	public static void main(String[] args) {
		String sa[] = {"one", "two", "three", "four"};
		Arrays.sort(sa);
		printContent(sa);
		
		System.out.println("now reverse sort");
		ReSortComparator rs = new ReSortComparator();
		Arrays.sort(sa, rs);
		printContent(sa);
		System.out.println("\none = " + Arrays.binarySearch(sa, "one", rs));

	}

	private static void printContent(String[] sa) {
		for(String s : sa) {
			System.out.println(s + " ");
		}
		System.out.println("\none = " + Arrays.binarySearch(sa, "one"));
	}

	static class ReSortComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			
			return o2.compareTo(o1);
		}
	}
}
