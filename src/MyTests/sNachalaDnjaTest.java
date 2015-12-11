package MyTests;

import java.util.Date;

/**
 * Created by r4geee on 01.05.2014.
 */
public class sNachalaDnjaTest
{
    public static void main(String[] args)
    {
        Date currentDate = new Date();
        int hours = currentDate.getHours();
        int mins = currentDate.getMinutes();
        int secs = currentDate.getSeconds();

        System.out.println("Time from midnight " + hours + ":" + mins + ":" + secs);
        System.out.println(currentDate.getMonth());
    }
}
