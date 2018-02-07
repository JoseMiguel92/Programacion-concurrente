package tema3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SincBarreraMal1 {
    private static final int NPROCESOS = 3;
    private static volatile int nProcesos;
    private static Semaphore sb;

    private static void proceso() throws InterruptedException {
        System.out.println("A");
        nProcesos++;
        if (nProcesos < NPROCESOS)
            sb.acquire();
        else
            for (int i = 0; i < NPROCESOS - 1; i++) {
                sb.release();
            }
        System.out.println("B");
    }

    public static void main(String[] args) {
        sb = new Semaphore(0);
        List<Thread> ths = new ArrayList<Thread>();
        for (int i = 0; i < NPROCESOS; i++) {
            Thread th = new Thread(new Runnable() {
                public void run() {
                    try {
                        proceso();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "proceso" + i);
            th.start();
            ths.add(th);
        }
    }
}
