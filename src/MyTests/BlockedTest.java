package MyTests;

/**
 * Created by Test on 03.12.2015.
 */
public class BlockedTest {

    static Object d = new Object();
    static Thread thread;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new FirstThread();
        Thread thread2 = new SecondThread();
        thread = thread1;
        thread1.start();
        thread2.start();

    }

    public static class FirstThread extends Thread {
        @Override
        public void run() {
            synchronized (d) {
                try {
                    System.out.println("a");
                    d.wait();
                    System.out.println("b");
                }
                catch (InterruptedException e) {
                }

            }
        }
    }

    public static class SecondThread extends Thread {
        @Override
        public void run() {
            synchronized (d) {
                System.out.println("hey");
                System.out.println("ho");
                System.out.println(thread.getState());
                d.notify();
                System.out.println(thread.getState());
                try {
                    Thread.sleep(10000);
                }
                catch (InterruptedException e) {

                }
                System.out.println("end");
            }
        }
    }
}
