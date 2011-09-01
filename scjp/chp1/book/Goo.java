package book;

import cert.*;

class Goo {
	
	public static void main(String[] args) {
		Sludge o = new Sludge();
		o.testIt();
		System.out.println("This is the version: "+ new Goo().getVersion());
	}
	
	public void testDeclareArrays() {
		String [][] key = {{}} ;
		int [] key2 [] = {{1,2}};
		final int [] arrayOfInt = {2,3,54,5,6};
		arrayOfInt[2] = 2;
	}
	
	private int x,y,z = 0;
	
	private static int lastVersion = -1;
    private int version; {
        String versionText = System.getProperty("A.version", String.valueOf(lastVersion));
        try {
            version = Integer.parseInt(System.getProperty("A.version", String.valueOf(lastVersion)));
        } catch (NumberFormatException nfe) {
            System.err.println("Unable to parse A.version "+versionText);
            version = lastVersion;
        }
		lastVersion += 1;
    }
	public int getVersion() {
		return version;
	}
	
	public void doStuff(String z, int... x) {}
}