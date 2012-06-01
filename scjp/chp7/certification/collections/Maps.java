package certification.collections;

import java.util.HashMap;
import java.util.Map;

class Cat {
	
}

class Dog {
	private String name;

	public Dog(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Dog)) {
			return false;
		}
		
		Dog other = (Dog) obj;
		if (other.name == null || name == null) {
			return other.name == null && name == null;
		} else {
			return name.equals(other.name);
		}
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
	@Override
	public String toString() {
		return "Dog [" + name + "]";
	}
}

class Hourse {
	private String name;

	public Hourse(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Hourse)) {
			return false;
		}
		
		Hourse other = (Hourse) obj;
		if (other.name == null || name == null) {
			return other.name == null && name == null;
		} else {
			return name.equals(other.name);
		}
	}
	
	@Override
	public String toString() {
		return "Dog [" + name + "]";
	}
}

public class Maps {

	public static void main(String[] args) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		
		m.put("k1", new Dog("pepe"));
		m.put("k2", new Dog("whiscas"));
		Dog dkey = new Dog("clover");
		m.put(dkey, dkey);
		Cat c1 = new Cat();
		m.put("k3", c1);
		Cat ckey = new Cat();
		m.put(ckey, ckey);
		
		Hourse h1 = new Hourse("billy");
		m.put("k4", h1);
		
		m.put(h1, h1);
		
		System.out.println("get k1: " + m.get("k1"));
		System.out.println("get dkey: " + m.get(new Dog("clover")));
		System.out.println("get k3: " + m.get("k3"));
		System.out.println("get ckey: " + m.get(new Cat()));
		System.out.println("get k4: " + m.get("k4"));
		System.out.println("get h1: " + m.get(new Hourse("billy")));
		System.out.println("contains ckey: " + m.containsValue(new Dog("clover")));
		System.out.println("contains ckey: " + m.containsValue(new Cat()));
		System.out.println("contains billy: " + m.containsValue(new Hourse("billy")));
	}
}
