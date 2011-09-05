package certification;

import java.util.Date;

public class Collector {
	
	public void execute() {
		Date d = null;
		for (int i = 0; i < 10000; i++) {
			d = new Date();
			d = null;
		}
	}
	
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		printMem(rt);
		new Collector().execute();
		printMem(rt);
		rt.gc();
		printMem(rt);
	}
	
	public static void printMem(Runtime rt){
		System.out.println("Total JVM Memory: "+ rt.totalMemory() 
			+ ". Free memory: " + rt.freeMemory());
	}
	
}