package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by Test on 5/11/2015.
 */
public class Producer implements Runnable
{
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        for (int i = 1; i < 10; i++)
        {
            ShareItem shareItem = new ShareItem("ShareItem-" + i, i);
            System.out.printf("Элемент '%s' добавлен ", shareItem.getDescription());
            System.out.println();
            queue.offer(shareItem);
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {

            }
            if (queue.hasWaitingConsumer())
            {
                System.out.println("Consumer в ожидании!");
            }
        }
    }
}
