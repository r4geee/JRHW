package MyTests.raznoe;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by r4geee on 04.10.2014.
 */
public class a0zero implements Comparable <a0zero>
{
    volatile static int a;
    public static void main(String[] args) throws IOException
    {

        //String regex = "\\<[^\\>]*\\>";
        // String regex = "\\<[^\\/][^\\>]*\\>";
        String regex = "\\<\\/[^\\>]*\\>";
        String input = "<span : HERE I GO! > SOME text</span> Info about Leela <span xml:lang=\"en\" lang=\"en\"><b><span>Turanga Leela</span></b></span><span>another text</span>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end());
            System.out.println(" Found: " + matcher.group());
        }
        System.out.println(input.matches(regex));
    }

    @Override
    public int compareTo(a0zero o)
    {
        return 0;
    }
}
