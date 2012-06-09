package certification.collections;

import java.util.Comparator;

public class PriorityQueue {

	static class PQSort implements Comparator<Integer>{

		@Override
		public int compare(Integer one, Integer two) {
			return two - one;
		}
	}
	
	public static void main(String[] args) {
		int ia[] = {1,5,3,6,7,2,11,9};
		java.util.PriorityQueue<Integer> pq2 = new java.util.PriorityQueue<Integer>(
			4, new PQSort());
		
		for (int x : ia) {
			pq2.offer(x);
		}
		l("size " + pq2.size());
		l("peek " + pq2.peek());
		l("size " + pq2.size());
		l("poll " + pq2.poll());
		l("size " + pq2.size());

		//Integer x;
		//while ((x = pq2.poll()) != null){
		for (int x : ia){
			l(pq2.poll()+ " ");
		}
}
	
	private static void l(String arg) {
		System.out.println(arg);
	}
}
