package workers;

import count.Count;

public class OnDuty implements Runnable {
    Count count;

    public OnDuty(Count count) {
        this.count = count;
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dutyAnswer();
    }


    public void dutyAnswer(){
        synchronized(count) {
            while (Count.getCount() <= 3) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(" All situation is good");
                count.notify();
                try {
                    count.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" Attention, we have fire !!!");
            count.notify();
        }
    }
}
