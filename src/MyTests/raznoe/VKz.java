package MyTests.raznoe;

/**
 * Created by Alexei on 30.03.2015.
 */
public class VKz
{
    static int S(int n)
    {
        if (n > 1)
        {
            return S(n - 1) + n;
        } else
        {
            return 1;
        }

    }

    public static void main(String[] args)
    {
        int sum = 0;
        int n = 0;
        while (sum < 1095)
        {
            n++;
            sum += numberOfDigits(n);
            System.out.println("n = " + n + " sum = " + sum);
        }
        System.out.println(n);
    }

    public static int numberOfDigits(int n)
    {
        int result = 0;
        while (n != 0)
        {
            n = n / 10;
            result++;
        }
        return result;
    }
}
