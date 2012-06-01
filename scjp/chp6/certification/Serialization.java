package certification;

import java.io.Console;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Cat implements Serializable {
	private int age;

	public Cat(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Cat of "+age+ " years old";
	}
}

public class Serialization {

	public static void main(String[] args) {
		Cat c = new Cat(2);
		Console console = System.console();
		console.printf("Please choose one option, 0.- write, 1.- read");
		while (true) {
			String line = console.readLine();
			char action = line.charAt(0);
			switch (action) {
			case '0':
				c = new Cat(line.charAt(1));
				write(c);
				console.printf("cat %s written", c);
				break;
			case '1':
				console.printf("Cat is: %s", read());
				break;
			case '6':
				System.exit(0);
			default:
				console.printf("Incorrect option %s", action);
				break;
			}
		}
	}

	private static void write(Cat c) {
		try {
			FileOutputStream fs = new FileOutputStream("cat.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(c);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Cat read() {
		try {
			FileInputStream fs = new FileInputStream("cat.ser");
			ObjectInputStream os = new ObjectInputStream(fs);
			return (Cat) os.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
