package MyTests;

/**
 * 666 tovar3 3.6 33
 */
public class checkDouble
{
    public static void main(String[] args)
    {
        String[] str = new String[] {"66", "tovar3", "3.6", "33"};
        for (int i = 0; i < str.length; i++)
        {
            if (checkDouble(str[i]))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }

    public static boolean checkDouble(String s)
    {
        try
        {
            Double.parseDouble(s);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }

    public static boolean checkInteger(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }

}
