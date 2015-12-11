package MyTests;

import com.javarush.test.level15.lesson06.task03.Solution;

/**
 * Created by Test on 12/19/2014.
 */
public class syncTest
{

    public static void main(String[] args)
    {
        Thread thread1 = new Thread(new testik());
        Thread thread2 = new Thread(new testik());
        thread1.start();
        thread2.start();
    }

    public static class testik implements Runnable
    {
        public static String a = "a";


        @Override
        public void run()
        {
            System.out.println(Thread.currentThread().getName());
            printA();
        }

        private synchronized static void printA()
        {
            int counter = 0;
            while (counter < 5)
            {
                System.out.print(a + counter);
                counter++;
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            System.out.println();

        }
    }
}
