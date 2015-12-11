package com.javarush.test.level30.lesson06.home01;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Alexei on 11.05.2015.
 */
public class BinaryRepresentationTask extends RecursiveTask<String>
{
    private int i;
    public BinaryRepresentationTask(int i)
    {
        this.i = i;
    }

    @Override
    protected String compute()
    {
        int a = i % 2;
        int b = i / 2;
        String result = String.valueOf(a);
        List<BinaryRepresentationTask> subTasks = new LinkedList<>();
        if (b > 0) {
            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
            task.fork();
            subTasks.add(task);
        }
        for (BinaryRepresentationTask task : subTasks)
        {
            result = task.join() + result;
        }
        return result;
    }
}

