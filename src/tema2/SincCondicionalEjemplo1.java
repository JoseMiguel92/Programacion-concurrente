package tema2;

import java.util.Random;

public class SincCondicionalEjemplo1 {
	static volatile boolean continuar;

	public static void procA() throws InterruptedException {
		new Thread(() -> {
			System.out.println("PA1 ");
			try {
				Thread.sleep(new Random().nextInt(10000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			continuar = true;
			System.out.println("PA2 ");
		}).start();
	}

	public static void procB() throws InterruptedException {
		new Thread(() -> {
			System.out.println("PB1 ");
			try {
				Thread.sleep(new Random().nextInt(10000));
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			while (!continuar) {
			}
			System.out.println("PB2 ");
		}).start();
	}

	public static void main(String[] args) throws InterruptedException {
		continuar = false;
		procA();
		procB();
	}
}