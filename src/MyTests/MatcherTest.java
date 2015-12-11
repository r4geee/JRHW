package MyTests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alexei on 27.12.2014.
 */
public class MatcherTest {
    public static void main(String[] args) {
        String s =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                        "<anExample>\n" +
                        "    <!--it's a comment - <needCDATA>-->\n" +
                        "\t<needCDATA>need CDATA because of lt and gb</needCDATA>\n" +
                        "    <!--it's a comment - <needCDATA>-->\n" +
                        "\t<needCDATA></needCDATA>\n" +
                        "</anExample>";
        String un = "(?<=>).*(?=</[^>]*>)";
        Pattern pattern = Pattern.compile(un);
        Matcher matcher = pattern.matcher(s);
        boolean found = false;
        while (matcher.find()) {
            System.out.printf("I found the text" +
                            " \"%s\" starting at " +
                            "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
            found = true;
        }
        if (!found) {
            System.out.printf("No match found.%n");
        }
    }

    private static void tagAndContent() {
        String s =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                        "<anExample>\n" +
                        "    <!--it's a comment - <needCDATA>-->\n" +
                        "\t<needCDATA>need CDATA because of lt and gb</needCDATA>\n" +
                        "    <!--it's a comment - <needCDATA>-->\n" +
                        "\t<needCDATA></needCDATA>\n" +
                        "</anExample>";

        String tagAndContentRegex = "<[^/][^>]*>[^<]*</[^>]*>";
        Pattern pattern = Pattern.compile(tagAndContentRegex);
        Matcher matcher = pattern.matcher(s);
        boolean found = false;
        while (matcher.find()) {
            System.out.printf("I found the text" +
                            " \"%s\" starting at " +
                            "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
            found = true;
        }
        if (!found) {
            System.out.printf("No match found.%n");
        }
    }

    private static void extractFroMEmptyTag() {
        String s =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                        "<anExample>\n" +
                        "    <!--it's a comment - <needCDATA>-->\n" +
                        "\t<needCDATA>need CDATA because of lt and gb</needCDATA>\n" +
                        "    <!--it's a comment - <needCDATA>-->\n" +
                        "\t<needCDATA></needCDATA>\n" +
                        "</anExample>";
        String emptyTagRegex = "<[^/][^>]*></[^>]*>";
        Pattern pattern = Pattern.compile(emptyTagRegex);
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            String tag = matcher.group().substring(matcher.group().lastIndexOf("/")+1, matcher.group().length()-1);
            System.out.println(tag);
        }
    }

    private static void tagContent1() {
        String tagContentRegex = "(?<=<[^/][^>]*>*?).*(?=</[^>]*>)";
        String s =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                        "<first>\n" +
                        "    <second>some string</second>\n" +
                        "    <second>some string</second>\n" +
                        "    <second>1</second>\n" +
                        "    <second>&lt;![CDATA[need CDATA because of &lt; and &gt;]]&gt;</second>\n" +
                        "</first>";
        Pattern pattern = Pattern.compile(tagContentRegex);
        Matcher matcher = pattern.matcher(s);
        boolean found = false;
        while (matcher.find()) {
            System.out.printf("I found the text" +
                            " \"%s\" starting at " +
                            "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
            found = true;
        }
        if (!found) {
            System.out.printf("No match found.%n");
        }
    }

    private static void tagContent() {
        String s =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                        "<first>\n" +
                        "    <second>some string</second>\n" +
                        "    <second>some string</second>\n" +
                        "    <second>1</second>\n" +
                        "    <second>&lt;![CDATA[need CDATA because of &lt; and &gt;]]&gt;</second>\n" +
                        "</first>";

        //String regex = ".*&lt;!\\[CDATA\\[.*&lt;.*\\]\\]&gt;.*";
        String regex = ">&lt;!\\[CDATA\\[.*&lt;.*\\]\\]&gt;.*<";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        boolean found = false;
        while (matcher.find()) {
            System.out.printf("I found the text" +
                            " \"%s\" starting at " +
                            "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
            found = true;
        }
        if (!found) {
            System.out.printf("No match found.%n");
        }
    }

    private static void test123() {
        String s = "zzzasdoooaasdooooooaasdkk";
        String regex = "asd";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "f" + matcher.group());
            System.out.println(stringBuffer.toString());
        }
        matcher.appendTail(stringBuffer);
        System.out.println(stringBuffer.toString());
    }

    private static void mainTest() {
        String s =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                        "<first>\n" +
                        "    <second>some string</second>\n" +
                        "    <second>some string</second>\n" +
                        "    <second><![CDATA[need CDATA because of < and >]]></second>\n" +
                        "    <second/>\n" +
                        "</first>";
        String tagsRegex = "<second>.*</second>";
        String CDATAregex = "";
        String tagsAndCDATA = "<second>(?!.*<!\\[CDATA\\[.*?\\]\\]>).*</second>";
        String tagsAndCDATAandSingle = "<second>(?!.*<!\\[CDATA\\[.*?\\]\\]>).*</second>|<second/>";
        Pattern pattern = Pattern.compile(tagsAndCDATAandSingle);

        Matcher matcher = pattern.matcher(s);
        boolean found = false;
        while (matcher.find()) {
            System.out.printf("I found the text" +
                            " \"%s\" starting at " +
                            "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
            found = true;
        }
        if (!found) {
            System.out.printf("No match found.%n");
        }
    }

    private static void replace() {
        String s =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                        "<first>\n" +
                        "    <second>some string</second>\n" +
                        "    <second>some string</second>\n" +
                        "    <second><![CDATA[need CDATA because of < and >]]></second>\n" +
                        "    <second/>\n" +
                        "</first>";
        System.out.println(s);
        s = s.replaceAll("<second>", "<!--it's a guano-->" + "<second>");
        System.out.println(s);
    }

    private static void matcherTest() {
        String s =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                        "<first>\n" +
                        "    <!--it's a comment-->\n" +
                        "    <second>some string</second>\n" +
                        "    <!--it's a comment-->\n" +
                        "    <second>some string</second>\n" +
                        "    <!--it's a comment-->\n" +
                        "    <second><![CDATA[need CDATA because of < and >]]></second>\n" +
                        "    <!--it's a comment-->\n" +
                        "    <second/>\n" +
                        "</first>";
        String s2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "</first>\n";

        String s3 = "</first>\n";
        //String regex = ".*\\\\(<\\/[^\\>]*\\>)+.*";
        String myRegex = ".*\\<\\/first\\>.*";
        Pattern pattern = Pattern.compile(myRegex);

        Matcher matcher = pattern.matcher(s3);
        System.out.println(matcher.matches());
    }
}

