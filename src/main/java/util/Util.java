package util;
import java.util.concurrent.atomic.AtomicInteger;

public class Util {

    public static void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waiting(AtomicInteger count, int time){
        try {
            count.wait(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
