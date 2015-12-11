package MyTests.test;

/**
 * Created by arostovshchikov on 26/8/2014.
 */
public class Sing
{
    private static Sing ourInstance = new Sing();

    public static Sing getInstance()
    {
        return ourInstance;
    }

    private Sing()
    {
    }
}
