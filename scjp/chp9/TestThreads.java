class FooRunnable implements Runnable {
	public void run() {
		for (int i = 0  ; i <= 100; i++) {
			System.out.println("Run by: "+ Thread.currentThread().getName() + " x is: " + i);
			if (i % 10 == 0) {
				try {
				
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

public class TestThreads {

	public static void main (String[] args) throws Exception {
		FooRunnable r1 = new FooRunnable();
		FooRunnable r2 = new FooRunnable();
		FooRunnable r3 = new FooRunnable();
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);

		t1.setName("Fred");
		t2.setName("Lucy");
		t3.setName("Ricky");

		t1.start();
		t2.start();
		t3.start();

	}
}