package MyTests.GolovachTests;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;

/**
 * Created by Alexei on 27.11.2014.
 */
public class Permute
{
    public static int counter = 0;
    public static void permute(int[] arr, int size)
    {
        if (size < 2)
            System.out.println(Arrays.toString(arr));
        else {
            for (int i = 0; i < size; i++)
            {
                swap(arr, i, size - 1);
                permute(arr, size - 1);
                swap(arr, i, size - 1);
            }
        }
    }

    public static void swap(int[] arr, int index0, int index1)
    {
        counter++;
        //System.out.print("Swap nr: " + counter + " Index0: " + index0 + " Index1: " + index1 + " Input array: " + Arrays.toString(arr));
        int a = arr[index0];
        arr[index0] = arr[index1];
        arr[index1] = a;
        //System.out.println(" Output array: " + Arrays.toString(arr));
    }

    public static void main(String[] args)
    {
        int[] arr = {0, 1, 2, 3};
        permute(arr, arr.length);
    }
}
