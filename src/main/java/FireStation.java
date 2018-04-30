import workers.Administrator;
import workers.Firemen;
import workers.OnDuty;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class FireStation {

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Administrator(count));
        executorService.submit(new OnDuty(count));
        executorService.submit(new Firemen(count));
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(15, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

    }
}
