package certification.collections;

import java.util.ArrayList;
import java.util.List;

public class ToArrays {

	public static void main(String[] args) {
		List<Integer> iL = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			iL.add(i);
		}
		iL.add(44);
		Object[] oa = iL.toArray();
		iL.remove(new Integer(44));
		System.out.println("oa : " );
		printArrayInfo(oa);
		
		Integer[] ia2 = new Integer[3];
		ia2 = iL.toArray(ia2);
		System.out.println("ia2 : ");
		printArrayInfo(ia2);

		oa = ia2;
		Object[] oa_fromIa = iL.toArray(oa);
		System.out.println("oa_fromIa : " );
		printArrayInfo(oa_fromIa);
	}
	
	private static void printArrayInfo(Object[] arg) {
		System.out.println("Size: " + arg.length);
		System.out.println("Type: " + arg.getClass());
		if (arg.length > 0) {
			System.out.println("First element class: "
				+ arg[0].getClass().getSimpleName());
		}
		
		for (Object element : arg) {
			System.out.println("\t"+element);
		}
	}

}
