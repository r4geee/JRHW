package MyTests;

import java.text.ChoiceFormat;
import java.text.ParsePosition;

/**
 * Created by Test on 12/16/2014.
 */
public class ChoiseFormatTest
{
    public static void main(String[] args)
    {
        double[] limits = {1,2,3,4,5,6,7};
        String[] dayOfWeekNames = {"Sun","Mon","Tue","Wed","Thur","Fri","Sat"};
        ChoiceFormat form = new ChoiceFormat(limits, dayOfWeekNames);
        ParsePosition status = new ParsePosition(0);
        for (double i = 0.0; i <= 8.0; ++i) {
            status.setIndex(0);
            System.out.println(i + " -> " + form.format(i) + " -> "
                    + form.parse(form.format(i),status));
        }
    }
}
