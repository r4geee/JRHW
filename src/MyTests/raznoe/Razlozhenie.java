package MyTests.raznoe;

import java.util.Arrays;

/**
 * Created by r4geee on 03.08.2014.
 */
public class Razlozhenie
{
    public static void main(String[] args)
    {
        int number = 72519204;
        int numberTemp = number;
        int numberOfDigits = 0;
        while (numberTemp != 0)
        {
            numberTemp = numberTemp / 10;
            numberOfDigits++;
        }
        int[] numberArray = new int[numberOfDigits];
        for(int i = 0; i < numberArray.length;i++)
        {
            numberArray[i] = number % 10;
            number = number / 10;
        }
        for(int i : numberArray)
            System.out.println(i);

        System.out.println();

        Arrays.sort(numberArray);
        for(int i : numberArray)
            System.out.println(i);
    }
}
