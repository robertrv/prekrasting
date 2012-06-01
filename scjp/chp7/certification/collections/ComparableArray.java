package certification.collections;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableArray {
	
	public static void main(String[] args) {
		
		ArrayList<DVD> dvds = new ArrayList<DVD>();
		
		dvds.add(new DVD("algo", "zzz"));
		dvds.add(new DVD("mas y mas", "bbb"));
		dvds.add(new DVD("zuzuz", "zuzu"));
		dvds.add(new DVD("rrrrr", "rrrr"));
		dvds.add(new DVD("el primero", "a"));
		
		System.out.println("unsorted: " + dvds);
		Collections.sort(dvds);
		System.out.println("sorted: " + dvds);
	}

}

class DVD implements Comparable<DVD> {

	String title;
	String author;
	
	public DVD(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}

	@Override
	public int compareTo(DVD o) {
		return this.author.compareTo(o.author);
	}
	
	@Override
	public String toString() {
		return "title: " + title + " author: " + author + " \n";
	}
	
}
