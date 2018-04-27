package count;

public class Count {

    private static volatile int count = 0;

    public static int getCount() {
        return count;
    }

    public static void incrementCount() {
        count++;
    }
}
