package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by Test on 5/11/2015.
 */
public class Consumer implements Runnable
{
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {

        }
        while (!Thread.currentThread().isInterrupted())
        {
            try
            {
                ShareItem shareItem = queue.take();
                System.out.println("Processing " + shareItem.toString());
            }
            catch (InterruptedException e)
            {

            }
        }
    }
}
