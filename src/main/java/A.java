import java.util.Random;

public class A implements Runnable {
    private int value;
    private Random r = new Random();

    public void run() {
        try {
            Thread.sleep(r.nextInt(2000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = r.nextInt();
    }

    public int getValue() {
        return value;
    }
}
