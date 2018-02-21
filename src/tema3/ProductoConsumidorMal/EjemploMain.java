package tema3.ProductoConsumidorMal;

import java.util.Random;

public class EjemploMain {
	private static ProductorConsumidorBuffer buffer;

	public static void productor() throws InterruptedException {
		for (int i = 0; i < 20; i++) {
			Thread.sleep(new Random().nextInt(10000));
			buffer.insertar(i);
		}
	}

	public static void consumidor() {
		while (true) {
			int data = buffer.sacar();
			try {
				Thread.sleep(new Random().nextInt(10000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(data + " ");
		}
	}

	public static void main(String[] args) {
		// buffer = new ProductorConsumidorBuffer();
		// List<Thread> threads = new ArrayList<>(NPROD + NCONS);
		// for (int i = 0; i < NPROD; i++) {
		// threads.add(new Thread(() -> productor()));
		// }
		// for (int i = 0; i < NCONS; i++) {
		// threads.add(new Thread(() -> consumidor()));
		// }
		// for (Thread)
	}
}
