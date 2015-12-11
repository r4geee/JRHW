package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static
    {
        threads.add(new ThreadOne());
        threads.add(new ThreadTwo());
        threads.add(new ThreadThree());
        threads.add(new ThreadFour());
        threads.add(new ThreadFive());
    }

    public static class ThreadOne extends Thread
    {
        @Override
        public void run()
        {
            while (true);
        }
    }

    public static class ThreadTwo extends Thread
    {
        @Override
        public void run()
        {
            try
            {
                Thread.sleep(10000);
            }
            catch (InterruptedException e)
            {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class ThreadThree extends Thread
    {
        @Override
        public void run()
        {
            try
            {
                while (true)
                {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException e)
            {

            }
        }
    }

    public static class ThreadFour extends Thread implements Message
    {
        @Override
        public void showWarning()
        {
            interrupt();

            if (isAlive())
            {
                try
                {
                    join();
                }
                catch (InterruptedException ignored)
                {
                }
            }
        }

        @Override
        public void run()
        {
            while(!isInterrupted());

        }
    }

    public static class ThreadFive extends Thread
    {
        @Override
        public void run()
        {
            try
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String s = reader.readLine();
                int sum = 0;
                while (!s.equals("N"))
                {
                    sum += Integer.parseInt(s);
                    s = reader.readLine();

                }
                System.out.println(sum);
            }
            catch (IOException e)
            {

            }


        }
    }
}


