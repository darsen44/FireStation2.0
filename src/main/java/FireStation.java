import workers.Administrator;
import count.Count;
import workers.Firemen;
import workers.OnDuty;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class FireStation {

    public static void main(String[] args) {
        Count count = new Count();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Administrator(count));
        executorService.submit(new OnDuty(count));
        executorService.submit(new Firemen(count));
        executorService.shutdown();

//        Thread admin = new Thread(new Administrator(count));
//        admin.start();
//        Thread onDuty = new Thread(new OnDuty(count));
//        onDuty.start();
//        Thread firemen = new Thread(new Firemen(count));
//        firemen.start();

    }
}
