package MyTests;


/**
 * Created by r4geee on 06.08.2014.
 */
public class Ref
{
    /*static Thread thread = new Thread()
    {
        public void run()
        {

        }
    };

    public static void main(String[] args)
    {
        thread.start();
    }*/

    static TigerThread tigerThread = new Ref().new TigerThread();

    private class TigerThread extends Thread
    {

        @Override
        public void run()
        {
            super.run();
        }
    }

    public static void main(String[] args)
    {

    }


}