package MyTests;

/**
 * Created by Test on 02.12.2015.
 */
public class ThTs {

    private String string1 = "string1";
    private String string2 = "string2";

    public static void main(String[] args) {
        ThTs thTs = new ThTs();
        HelpThread1 thread1 = new HelpThread1(thTs);
        HelpThread2 thread2 = new HelpThread2(thTs);
        thread1.start();
        thread2.start();
    }
    public synchronized void f1() {

            System.out.println("f1 " + string1);
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {

            }
            System.out.println("f1 " + string2);

    }

    public synchronized void f2() {

            System.out.println("f2 " + string1);
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {

            }
            System.out.println("f2 " + string2);

    }

    public static class HelpThread1 extends Thread {
        ThTs thTs;

        public HelpThread1(ThTs thTs) {
            this.thTs = thTs;
        }

        @Override
        public void run() {
            thTs.f1();
        }
    }

    public static class HelpThread2 extends Thread {
        ThTs thTs;

        public HelpThread2(ThTs thTs) {
            this.thTs = thTs;
        }

        @Override
        public void run() {
            thTs.f2();
        }
    }
}
