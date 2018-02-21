package tema4.monitores;

import java.util.ArrayDeque;
import java.util.Queue;

public class Monitor {
	private static final int PRECIO = 50;
	private Queue<String> solicitudes;
	private int dinero;

	public Monitor() {
		solicitudes = new ArrayDeque<>();
		dinero = 0;
	}

	public synchronized void comprar(String cliente) {
		while (!solicitudes.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		solicitudes.add(cliente);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notifyAll();
	}

}
