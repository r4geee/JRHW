package MyTests.test;

/**
 * Created by r4geee on 24.08.2014.
 */
public class Trololo implements TestInterface
{
    public static void main(String[] args)
    {
        Trololo trololo = new Trololo();
        System.out.println(Trololo.i);

    }

    @Override
    public int getint()
    {
        return 0;
    }

    @Override
    public double getdouble()
    {
        return 0;
    }
}
