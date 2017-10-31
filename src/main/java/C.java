import java.util.Random;

public class C implements Runnable {
    private int value;
    private Random r = new Random();
    private double duration;

    public void run() {
        long startTime = System.currentTimeMillis();

        try {
            Thread.sleep(r.nextInt(2000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = r.nextInt();

        long endTime = System.currentTimeMillis();
        duration = (endTime - startTime) / 1000.0;
    }

    public int getValue() {
        return value;
    }

    public double getDuration() {
        return duration;
    }
}