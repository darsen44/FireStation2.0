package workers;

import count.Count;

public class Administrator implements Runnable {
    Count count;

    public Administrator(Count count) {
        this.count = count;
    }

    public void run() {

        speakWithDuty();

    }

    public  void speakWithDuty() {
        synchronized (count) {
            while (Count.getCount() <= 4) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Fireman on duty, what is the situation now?");
                count.notify();
                try {
                    count.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Count.incrementCount();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("All firemen: Anxiety!!!");
            count.notifyAll();
        }
    }

}
