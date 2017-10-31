import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main (String[] args) throws InterruptedException {

        if (args.length == 1) {

            A a = new A();
            C c = new C();
            B b = new B();


            /*
            Neviem, ci je ziadane aby algoritmy mohli bezat sucastne ak ano tak:
            Executors.newCachedThreadPool() - vsetky vypocty bezia naraz, kazdy v inom vlakne
            inak:
            Executors.newSingleThreadExecutor(); - pouziva iba 1 vlakno, nemoze bezat viac vypoctov naraz
             */
            ExecutorService e = Executors.newCachedThreadPool();
            e.execute(a);
            e.execute(b);
            e.execute(c);

            e.shutdown();
            e.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);



            if (args[0].equals("all")) {
                System.out.println("A," + a.getDuration() + "s," + a.getValue());
                System.out.println("B," + b.getDuration() + "s," + b.getValue());
                System.out.println("C," + c.getDuration() + "s," + c.getValue());

            } else if (args[0].equals("first")){
                double smallest = Math.min(a.getDuration(), Math.min(b.getDuration(), c.getDuration()));
                if (smallest == a.getDuration()) {
                    System.out.println("A," + a.getDuration() + "s," + a.getValue());
                } else if (smallest == b.getDuration()) {
                    System.out.println("B," + b.getDuration() + "s," + b.getValue());
                } else {
                    System.out.println("C," + c.getDuration() + "s," + c.getValue());
                }

            } else {
                throw new IllegalArgumentException("Invalid argument: " + args[0]);
            }

        } else {
            throw new IllegalArgumentException("Invalid arguments!");
        }
    }
}
