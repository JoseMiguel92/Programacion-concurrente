package tema3.Filosofos;

import java.util.concurrent.Semaphore;

public class EjemploMain {

	public static int numPhilos = 5;
	public static Semaphore[] forkSem = new Semaphore[numPhilos];

	public static void main(String[] args) {
		for (int i = 0; i < forkSem.length; i++) {
			forkSem[i] = new Semaphore(1);
		}
		for (int i = 0; i < numPhilos; i++) {

		}
	}
}
