package com.javarush.test.level28.lesson06.home01;

/**
 * Created by Test on 4/28/2015.
 */
public class MyThread extends Thread
{
    public static int nextPriority;
    public MyThread()
    {
        super();
        setPriority();
    }

    public MyThread(Runnable target)
    {
        super(target);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        setPriority();
    }

    public MyThread(String name)
    {
        super(name);
        setPriority();
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        setPriority();
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        setPriority();
    }

    private void setPriority()
    {
        nextPriority++;
        if (nextPriority > 10)
        {
            nextPriority = 1;
        }
        if (this.getThreadGroup().getMaxPriority() < nextPriority)
        {
            this.setPriority(this.getThreadGroup().getMaxPriority());
        }
        else
        {
            this.setPriority(nextPriority);
        }
    }
}
