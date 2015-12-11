package MyTests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by arostovshchikov on 7/10/2014.
 */
public class a0tagCount
{
    public static void main(String[] args)
    {
        String s = "<span><span : HERE I GO! > SOME text</span> Info about Leela <span xml:lang=\"en\" lang=\"en\"><b><span>Turanga Leela</span></b></span><span>another text</span></span>";
        System.out.println(tagCountInString(s, "opening"));
        System.out.println(tagCountInString(s, "closing"));
        System.out.println(tagCountInStringNew(s, "opening"));
        System.out.println(tagCountInStringNew(s, "closing"));
    }

    public static int tagCountInString(String s, String element)
    {
        int count = 0;
        if (element.equals("opening"))
            //count = s.length() - s.replaceAll("<" + "\\p{Alnum}", "").length();
            count = s.length() - s.replaceAll("<" + "\\p{Alnum}", "").replaceAll("<>", "").replaceAll("< ", "").length();
        else if (element.equals("closing"))
            count = s.length() - s.replaceAll("</", "").length();
        return count;
    }

    public static int tagCountInStringNew(String s, String element)
    {
        int count = 0;
        String regex = "";
        if (element.equals("opening"))
            regex = "\\<[^\\/][^\\>]*\\>";
        else if (element.equals("closing"))
            regex = "\\<\\/[^\\>]*\\>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find())
        {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end());
            System.out.println(" Found: " + matcher.group());
            count++;
        }
        return count;
    }
}
