package MyTests.raznoe;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by r4geee on 30.04.2014.
 */
public class DataTest
{
    public static void main(String[] args)
    {
        Date today = new Date();
        Date date = new Date(new GregorianCalendar(1988,12,15).getTimeInMillis());
        System.out.print(today);
        System.out.println(date);
    }
}
