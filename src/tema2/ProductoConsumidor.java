package tema2;

import java.util.Random;

public class ProductoConsumidor {
	private static double producto;
	private static volatile boolean continuar;

	public static void productor() throws InterruptedException {
		Thread tProductor = new Thread(() -> {
			while(continuar) {};
			producto = new Random().nextDouble();
			continuar = true;
		}, "productor");
		tProductor.start();
	}

	public static void consumidor() throws InterruptedException {
		Thread tConsumidor = new Thread(() -> {
			while (!continuar) {};
			System.out.println("Consumido: "+producto);
			producto=-1;
			continuar=false;
		}, "consumidor");
		tConsumidor.start();
	}

	public static void main(String[] args) throws InterruptedException {
		continuar = false;
		productor();
		consumidor();
	}
}
