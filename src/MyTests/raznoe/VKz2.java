package MyTests.raznoe;

import java.util.Scanner;

/**
 * Created by Alexei on 01.04.2015.
 */
public class VKz2
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        long k = scanner.nextLong();
        System.out.println(f(k));
    }

    private static long f(long k)
    {
        int step = 0;
        long currentLastChar = 0;
        long currentNumber = 1;
        outer:
        for (int tenPow = 0; ; tenPow++ )
        {
            step++;
            if(currentLastChar + step * Math.pow(10, tenPow) * 9 < k)
            {
                currentNumber += Math.pow(10, tenPow) * 9;
                currentLastChar += step * Math.pow(10, tenPow) * 9;
                continue;
            }
            for(int i = 0; i < Math.pow(10 , tenPow) * 9; i++)
            {
                if (currentLastChar + step > k )
                {
                    break outer;
                }
                currentNumber++;
                currentLastChar += step;
            }
        }
        long charInNumber = k - currentLastChar;
        for (long i = 1; i < step - charInNumber; i++ )
        {
            currentNumber = currentNumber / 10;
        }
        while (currentNumber >= 10)
        {
            currentNumber = currentNumber % 10;
        }
        return currentNumber;
    }
}
