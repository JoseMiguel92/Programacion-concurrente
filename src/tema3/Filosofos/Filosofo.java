package tema3.Filosofos;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Filosofo extends Thread {
	private int numPhil;
	private int leftFork;
	private int rightFork;
	private Semaphore[] forkSem;

	public Filosofo(int numPhil) {
		this.numPhil = numPhil;
		this.leftFork = numPhil;
		this.rightFork = (numPhil + 1) % forkSem.length;
	}

	private void comer() throws InterruptedException {
		forkSem[leftFork].acquire();
		forkSem[rightFork].acquire();
		System.out.println("Filosofo " + (numPhil + 1) + " comiendo.");
		Thread.sleep(500 + new Random().nextInt(500));
		System.out.println("Filosofo " + (numPhil + 1) + " terminando.");
		forkSem[rightFork].release();
		forkSem[leftFork].release();
	}

	private void pensar() throws InterruptedException {
		System.out.println("Filosofo " + (numPhil + 1) + " pensando.");
		Thread.sleep(500 + new Random().nextInt(500));
		System.out.println("Filosofo " + (numPhil + 1) + " terminando.");
	}

	@Override
	public void run() {
		while (true) {

		}
	}

}
