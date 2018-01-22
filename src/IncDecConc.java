public class IncDecConc {
	static volatile double x;

	public static void incConc() throws InterruptedException {
		Thread th1 = new Thread(new Runnable() {
			@Override
			public void run() {
				x = x + 1;
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Hilo1");
		th1.start();
		th1.join();
	}

	public static void decConc() throws InterruptedException {
		Thread th2 = new Thread(new Runnable() {
			@Override
			public void run() {
				x = x - 1;
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Hilo2");
		th2.start();
		th2.join();
	}

	public static void main(String[] args) throws InterruptedException {
		incConc();
		decConc();
		System.out.println("x:" + x);
	}
}