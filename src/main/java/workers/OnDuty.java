package workers;


import util.Util;

import java.util.concurrent.atomic.AtomicInteger;

public class OnDuty implements Runnable {

    private final AtomicInteger count;

    public OnDuty(AtomicInteger count) {
        this.count = count;
    }

    public void run() {
        Util.sleep();
        dutyAnswer();
    }


    private void dutyAnswer(){
        synchronized(count) {
            while (count.get() <= 3) {
                Util.sleep();
                System.out.println(" All situation is good");
                count.notify();
                Util.waiting(count,0);
            }
            Util.sleep();
            System.out.println(" Attention, we have fire !!!");
            count.notify();
        }
    }
}
