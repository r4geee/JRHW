package com.javarush.test.level25.lesson09.task03;

import java.util.ArrayList;
import java.util.List;

/* Живем своим умом
В классе Solution реализуйте интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений начиная с самого вложенного.
Пример исключения: new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/
public class Solution implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (!t.isInterrupted())
        {
            t.interrupt();
        }
        List <Throwable> list = new ArrayList<>();
        while (true)
        {
            list.add(0, e);
            if (e.getCause() == null)
            {
                break;
            }
            e = e.getCause();
        }
        for (Throwable throwable : list)
        {
            System.out.println(throwable);
        }

    }

    public static void main(String[] args)
    {
        Thread thread = new Thread()
        {
            public void run()
            {
                    throw new RuntimeException("DEF", new IllegalAccessException("GHI"));
            }
        };
        thread.setUncaughtExceptionHandler(new Solution());
        thread.start();
    }
}
