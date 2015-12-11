package MyTests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Test on 10.12.2015.
 */
public class RecTest {

    public static void main(String[] args) {
        //f("sin(2*(-5+1.5*4)+28)+sin(30)");
        f2();
    }

    static String f(String expr) {
        String insideBracketsRegex = "\\([^\\(]*?\\)";
        String sinRegex = "sin\\(\\d+\\)";
        Pattern pattern = Pattern.compile(insideBracketsRegex);
        Matcher matcher = pattern.matcher(expr);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        return null;
    }

    static void f() {
        String s = "abcdaaad";
        String regex = "(a\\D{2}d)&&(^(aaad))";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    static void f1() {
        String s = "2";
        String regex = "[0-9&&[^345]]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    static void f2() {
        String s = "cos(sin(2*(-5+1.5*4)+28)+sin(30))+tag(90)";
        //String regex = "\\(.*?\\)[^\\)]+\\(?.*";
        //String regex = "\\(.*?\\)(?![a-z0-9+-^*/]*\\))";
        String asd = "\\(([^\\(\\)]*\\([^\\)]*\\)[^\\)\\(]*)*\\)";
        Pattern pattern = Pattern.compile(asd);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    static void f3() {
        String s = "qauqaeu";
        String regex = "qa[\\w]*?(?=u)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
