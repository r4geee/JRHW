package MyTests.raznoe;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by r4geee on 13.07.2014.
 */
public class SubString
{
    public static void main(String[] args) throws IOException
    {
/*        String s = "501<span>234</spank>567";

        int a = s.indexOf("<");
        int b = s.indexOf(">");
        int c = s.lastIndexOf("</");
        int d = s.lastIndexOf(">");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println();
        System.out.println(s.substring(a+1,b));
        System.out.println(s.substring(c+1,d));
        System.out.println();
        int ggg = s.indexOf("*");
        System.out.println(ggg);*/
        //test();
     /*   FileInputStream fileInputStream = new FileInputStream("C:/1.txt");
        ByteArrayOutputStream buf = new ByteArrayOutputStream();

        while (fileInputStream.available() > 0)
        {
            int data = fileInputStream.read();
            buf.write(data);
        }
        String s = buf.toString();
        System.out.println(s);
        System.out.println("=======================");
        System.out.println(test1(s));*/
        test6();
    }

    private static void test6()
    {
        StringBuilder sb = new StringBuilder("aaaa   ");
        System.out.println(sb);
        System.out.println(sb.toString().trim());
    }

    private static void test5()
    {
        String s = "a    b";
        s = s.replaceAll("[\\s]+", " ");
        System.out.println(s);
    }

    public static void test()
    {
        String s = "a@123566!";
        int startIndex = s.indexOf("1");
        int endIndex = s.indexOf("!");
        System.out.println(startIndex + " " + endIndex);
        System.out.println(s.substring(startIndex, endIndex+1));
    }

    public static String test1(String s)
    {
        String regex = "\\>[^\\<]*\\<";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find())
        {

            String toFixPart = matcher.group();
            //System.out.println("Found: " + toFixPart);
            String fixedPart = toFixPart.replaceAll(System.lineSeparator(), "");
            //System.out.println("Fixed: " + fixedPart);
            s = s.replaceAll(toFixPart, fixedPart);
        }
        return s;
    }

    public static void test2()
    {
        String s0 = "<span>";
        String s1 = "<span             \n" +
                " текст           \n" +
                " \n" +
                " \n" +
                " \n" +
                " \n" +
                " >";
        String s2 = "<span      /       \n" +
                " текст           \n" +
                " \n" +
                " \n" +
                " \n" +
                " \n" +
                " >  SOME русский текст     </span>";
        String s3 = "<span             \n" +
                " текст           \n" +
                " \n" +
                " \n" +
                " \n" +
                " \n" +
                " >  SOME русский текст     </span>\n" +
                "<span>раз<span>два<span>три</span></span></span>\n" +
                "<span>два<span>три</span></span>\n" +
                "<span>три</span>\n" +
                "<span>два<span>три</span></span>\n" +
                "<span>три</span>\n" +
                "<span>три</span>";
        String openingTagRegex = "\\<[^\\/]+[^\\<^\\>]*\\>";
        String closingTagRegex = "\\<\\/[^\\<^\\>^\\/]*\\>";
        String dataRegex = "\\>[^\\<^\\>]*\\<";
        Pattern pattern1 = Pattern.compile(openingTagRegex);
        Matcher matcher1 = pattern1.matcher(s3);
        while (matcher1.find())
        {
            System.out.println(matcher1.group());
        }
    }

    public static void test3()
    {
        String s = "<span        /         текст >";
        s = s.replaceAll("[\\s]+", " ").replaceAll(" \\>", "\\>");
        System.out.println(s);
    }

    public static void test4()
    {
        String s = "asd.html";
        String[] temp = s.split("\\.");
        System.out.println(temp[temp.length-1]);
    }
}
