package workers;
import count.Count;

public class Firemen implements Runnable {
    Count count;

    public Firemen(count.Count count) {
        this.count = count;
    }

    public void run() {

        firemenAnswer();
    }

    public  void firemenAnswer(){
        synchronized(count) {
            try {
                count.wait(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" Firemen: We  will save the earth!");
        }
    }
}
