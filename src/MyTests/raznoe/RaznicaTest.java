package MyTests.raznoe;

import java.util.Date;

/**
 * Created by r4geee on 30.04.2014.
 */
public class RaznicaTest
{
    public static void main(String[] args) throws Exception
    {
        Date currentTime = new Date();
        Thread.sleep(3000);
        Date newTime = new Date();

        long msDelay = newTime.getTime() - currentTime.getTime();
        System.out.println("Time distance is: " + msDelay + " in ms");
    }
}
