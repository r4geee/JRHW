package MyTests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by arostovshchikov on 7/7/2014.
 */
public class QuickTest1
{

    public static class Asd1 extends Thread
    {
        @Override
        public void run()
        {
            synchronized (System.out)
            {
                try
                {
                    Thread.sleep(10000);
                }
                catch (InterruptedException e)
                {

                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static class Asd2 extends Thread
    {
        @Override
        public void run()
        {
            synchronized (this)
            {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args)
    {
        new Asd1().start();
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {

        }
        new Asd2().start();
    }


}
