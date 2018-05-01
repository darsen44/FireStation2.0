package workers;

import util.Util;

import java.util.concurrent.atomic.AtomicInteger;

public class Administrator implements Runnable {

    private final AtomicInteger count;

    public Administrator(AtomicInteger count) {
        this.count = count;
    }

    public void run() {
        speakWithDuty();
    }

    private void speakWithDuty() {
        synchronized (count) {
            while (count.get() <= 4) {
                Util.sleep();
                System.out.println("Fireman on duty, what is the situation now?");
                count.notify();
                Util.waiting(count, 0);
                count.incrementAndGet();
            }
            Util.sleep();
            System.out.println("All firemen: Anxiety!!!");
            count.notifyAll();
        }
    }

}
