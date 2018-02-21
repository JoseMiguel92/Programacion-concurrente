package tema4;

import java.util.ArrayList;
import java.util.List;

public class IncDecSynchronized {
	private static double x = 0;
	private static Object xLock = new Object();

	public static void inc() {
		for (int i = 0; i < 10000000; i++) {
			synchronized (xLock) {
				x = x + 1;
			}
		}
	}

	public static void dec() {
		for (int i = 0; i < 10000000; i++) {
			synchronized (xLock) {
				x = x - 1;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// Crear 3 hilos que ejecutan inc() y esperar a que acaben ...
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < args.length; i++) {
			Thread th = new Thread(() -> inc());
			threads.add(th);
			th.start();
			Thread thD = new Thread(() -> dec());
			threads.add(thD);
			thD.start();
		}
		for (Thread thread : threads) {
			thread.join();
		}
		System.out.println("x:" + x);
	}
}
