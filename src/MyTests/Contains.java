package MyTests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by r4geee on 13.07.2014.
 */
public class Contains
{
    public static void main(String[] args)
    {
        String s = "+38(050)123-45-67";
        String formatted = "";
        for (int i = 0; i <s.length();i++)
        {
            if (Character.isDigit(s.charAt(i)))
            {
                formatted = formatted + s.charAt(i);
            }
        }
        System.out.println(formatted);



    }
}
