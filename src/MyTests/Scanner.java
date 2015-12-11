package MyTests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by r4geee on 13.07.2014.
 */
public class Scanner
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("D:\\asd.txt");
        java.util.Scanner scanner = new java.util.Scanner(file);

        /*
        if (scanner.hasNext())
        {
            String last = scanner.next();
            String first = scanner.next();
            String middle = scanner.next();
            int day = scanner.nextInt();
            int month = scanner.nextInt()-1;
            int year = scanner.nextInt();
            Calendar date = new GregorianCalendar(year, month, day);
            System.out.println(last+first+middle+day+month+year);
        }
        */
        String s = scanner.nextLine();
        String[] splitted = s.split(" ");
        String lastName = splitted[0];
        String firstName = splitted[1];
        String middleName = splitted[2];
        System.out.println(s);


    }
}
