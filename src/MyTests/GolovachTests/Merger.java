package MyTests;

import java.util.Arrays;

/**
 * Created by Alexei on 03.12.2014.
 */
public class Merger
{
    public static void main(String[] args)
    {
        int[] array1 = {1,4,5,9};
        int[] array2 = {2,3,7,8};
        System.out.println(Arrays.toString(merger(array1, array2)));
    }

    public static int[] merger (int[] array1, int[]array2)
    {
        int[] result = new int[array1.length + array2.length];
        int array1Index = 0;
        int array2Index = 0;
        while (array1Index < array1.length && array2Index < array2.length)
        {
            if (array1[array1Index] < array2[array2Index])
            {
                result[array1Index+array2Index] = array1[array1Index++];
            }
            else
            {
                result[array1Index+array2Index] = array2[array2Index++];
            }
        }

        while (array1Index < array1.length)
        {
            result[array1Index+array2Index] = array1[array1Index++];
        }

        while (array2Index < array2.length)
        {
            result[array1Index+array2Index] = array2[array2Index++];
        }
        return result;
    }
}
