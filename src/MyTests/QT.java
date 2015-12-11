package MyTests;

/**
 * Created by arostovshchikov on 10/7/2014.
 */
public class QT
{
    public static void main(String[] args)
    {
        int paramCounter = 1;
        for(int i = 0;i<100;i++)
        {
            System.out.println(paramCounter);
            paramCounter = ++paramCounter % 4;
        }
    }
}
