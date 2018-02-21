package tema4.counter;

public class Counter {
	private int x = 0;

	public synchronized void inc() {
		x = x + 1;
	}

	public int getValue() {
		return x;
	}
}
