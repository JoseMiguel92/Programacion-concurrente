package tema3.LectoresEscritores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class EjemploMain {

	private static int readerCount;
	private static Semaphore resourceSem;
	private static Semaphore readerSem;
	private static Semaphore queueSem;

	public static void writer() {
		while (true) {
			try {
				queueSem.acquire();
				resourceSem.acquire();
				queueSem.release();
				System.out.println("Escritor escribiendo.");
				resourceSem.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public static void reader() {
		while (true) {
			readerCount++;
			try {
				queueSem.acquire();
				readerSem.acquire();
				if (readerCount == 1) {
					resourceSem.acquire();
				}
				queueSem.release();
				readerSem.release();
				System.out.println("Lector leyendo...");
				readerSem.acquire();
				readerCount--;
				if (readerCount == 0) {
					resourceSem.release();
				}
				readerSem.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) throws InterruptedException {
		resourceSem = new Semaphore(1);
		readerSem = new Semaphore(1);
		List<Thread> threads = new ArrayList<>();
		threads.add(new Thread(() -> reader(), "Lector 1"));
		threads.add(new Thread(() -> reader(), "Lector 2"));
		threads.add(new Thread(() -> writer(), "Escritor 1"));
		threads.add(new Thread(() -> writer(), "Escritor 2"));
		for (Thread thread : threads) {
			thread.start();
		}
		for (Thread thread : threads) {
			thread.join();
		}
	}

}
