package workers;
import util.Util;

import java.util.concurrent.atomic.AtomicInteger;

public class Firemen implements Runnable {

    private final AtomicInteger count;

    public Firemen(AtomicInteger count) {
        this.count = count;
    }

    public void run() {

        firemenAnswer();
    }

    private void firemenAnswer(){
        synchronized(count) {
            Util.waiting(count,100);
            Util.sleep();
            System.out.println(" Firemen: We  will save the earth!");
        }
    }
}
