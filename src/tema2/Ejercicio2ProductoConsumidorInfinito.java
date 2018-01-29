package tema2;

import java.util.Random;

public class Ejercicio2ProductoConsumidorInfinito {
	static volatile double numero;
	static volatile boolean hay;

	public static void productor() throws InterruptedException {
		while (true) {
			while (hay) {}
			new Thread(() -> {
				numero = new Random().nextDouble();
				hay = true;
			}).start();
		}
	}

	public static void consumidor() throws InterruptedException {
		while (true) {
			new Thread(() -> {
				while (!hay) {
					try {
						Thread.sleep(new Random().nextInt(100));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(numero);
			}).start();
		}

	}

	public static void main(String[] args) throws InterruptedException {
		hay = false;
		productor();
		consumidor();
	}
}
