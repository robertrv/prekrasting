package certification.collections;

import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Ferry {
	
	public static void main(String[] args) {
		TreeSet<Integer> times = new TreeSet<Integer>();
		times.add(1205);
		times.add(1505);
		times.add(1545);
		times.add(1830);
		times.add(2010);
		times.add(2100);
		
		TreeSet<Integer> subset = new TreeSet<Integer>();
		subset = (TreeSet<Integer>) times.headSet(1600);
		System.out.println(subset);
		System.out.println("J5 - last before 4pm is: " + subset.last());
		
		TreeSet<Integer> sub2 = new TreeSet<Integer>();
		sub2 = (TreeSet<Integer>) times.tailSet(2000);
		System.out.println(sub2);
		System.out.println("J5 - first after 8pm is: " + sub2.first());
		
		System.out.println("J6 - last before 4pm is: " + times.lower(1600));
		System.out.println("J6 - first after 8pm is : " + times.higher(2000));
		
		TreeMap<String, Pet> map = new TreeMap<String, Pet>();
		Pet pet = new Pet("d");
		map.put("a", new Pet("a"));
		map.put("d", pet);
		map.put("h", new Pet("house"));
		
		NavigableMap<String, Pet> submap = map.subMap("b", true, "g", true);
		System.out.println(map + " " + submap);
		
		map.put("b", new Pet("b"));
		
		submap.put("f", new Pet("f"));
		submap.put("d", new Pet("other thing"));
		map.put("r", new Pet("r"));
		//submap.put("p", "pig");
		
		System.out.println(map + " " + submap);
		
		submap.put("b", new Pet("other value"));
		System.out.println(map + " " + submap);
		
		System.out.println("polled: " +submap.pollFirstEntry());
		System.out.println(map + " " + submap);

		System.out.println("polled: " +map.pollFirstEntry());
		System.out.println(map + " " + submap);
		System.out.println("polled: " +map.pollFirstEntry());
		System.out.println(map + " " + submap);
		System.out.println("polled: " +map.pollFirstEntry());
		System.out.println(map + " " + submap);

	}

}

class Pet {
	private String name;
	public Pet(String name) {
		this.setName(name);
	}
	
	@Override
	public String toString() {
		return getName();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}