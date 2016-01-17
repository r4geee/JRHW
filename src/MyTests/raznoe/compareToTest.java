package MyTests.raznoe;

/**
 * Created by r4geee on 05.06.2014.
 */
public class compareToTest
{
    public static void main(String args[])
    {
        String str1 = "Strings are immutable";
        String str2 = "Strings are immutable";
        String str3 = "Integers are not immutable";

        int result = str1.compareTo( str2 );
        System.out.println(result);

        result = str2.compareTo( str3 );
        System.out.println(result);

        result = str3.compareTo( str1 );
        System.out.println(result);

        String a = "mulberry";
        String b = "custard";
        System.out.println(a.compareTo(b));

        ditja Denis = new ditja();
        Denis.getIntT();
    }

    public static class rodak
    {
        private int intT;
        private String strS;

        public int getIntT()
        {
            return intT;
        }
    }

    public static class ditja extends rodak
    {
        private boolean lol;
    }
}
