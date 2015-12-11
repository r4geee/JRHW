package MyTests;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Alexei on 25.12.2014.
 */
public class QueueTest
{
    public static void main(String[] args)
    {
        Comparator<Integer> comparator = new Comparator<Integer>()
        {

            @Override
            public int compare(Integer o1, Integer o2)
            {
                if (o1 > o2)
                {
                    return -1;
                }
                if (o1 < o2)
                {
                    return 1;
                }
                return 0;
            }
        };
        Queue<Integer> intQueue = new PriorityQueue<>(10, comparator);
        intQueue.add(4);
        intQueue.add(3);
        intQueue.add(1);
        while (!intQueue.isEmpty())
        {
            System.out.println(intQueue.remove());
        }
    }
}
