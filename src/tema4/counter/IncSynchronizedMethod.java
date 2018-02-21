package tema4.counter;

import java.util.ArrayList;
import java.util.List;

public class IncSynchronizedMethod {

	private static Counter c = new Counter();

	public static void inc() {
		for (int i = 0; i < 1000; i++) {
			c.inc();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Thread th = new Thread(() -> inc());
			threads.add(th);
			th.start();
		}
		for (Thread thread : threads) {
			thread.join();
		}
		System.out.println("x:" + c.getValue());
	}

}
