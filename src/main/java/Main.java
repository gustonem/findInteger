public class Main {
    public static void main (String[] args) throws InterruptedException {

        if (args.length == 1) {
            A a = new A();
            Thread t = new Thread(a, "A");
            long startTime = System.currentTimeMillis();
            t.start();
            t.join();
            long endTime = System.currentTimeMillis();
            double durationA = (endTime - startTime) / 1000.0;

            B b = new B();
            Thread t1 = new Thread(b, "B");
            startTime = System.currentTimeMillis();
            t1.start();
            t1.join();
            endTime = System.currentTimeMillis();
            double durationB = (endTime - startTime) / 1000.0;

            C c = new C();
            Thread t2 = new Thread(c, "C");
            startTime = System.currentTimeMillis();
            t2.start();
            t2.join();
            endTime = System.currentTimeMillis();
            double durationC = (endTime - startTime) / 1000.0;

            if (args[0].equals("all")) {
                System.out.println(t.getName() + "," + durationA + "s," + a.getValue());
                System.out.println(t1.getName() + "," + durationB + "s," + b.getValue());
                System.out.println(t2.getName() + "," + durationC + "s," + c.getValue());

            } else if (args[0].equals("first")){
                double smallest = Math.min(durationA, Math.min(durationB, durationC));
                if (smallest == durationA) {
                    System.out.println(t.getName() + "," + durationA + "s," + a.getValue());
                } else if (smallest == durationB) {
                    System.out.println(t1.getName() + "," + durationB + "s," + b.getValue());
                } else {
                    System.out.println(t2.getName() + "," + durationC + "s," + c.getValue());
                }

            } else {
                throw new IllegalArgumentException("Invalid argument: " + args[0]);
            }

        } else {
            throw new IllegalArgumentException("Invalid arguments!");
        }
    }
}
