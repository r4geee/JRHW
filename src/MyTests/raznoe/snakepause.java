package MyTests.raznoe;

/**
 * Created by Alexei on 01.12.2014.
 */
public class snakepause
{
    public static void pause()
    {
        double startPause = 300 + (double) 2001 / 9;
        double levelPlus = (double) 200 / 9;
        //double pauseDoubleTemp = new BigDecimal(startPause - multiplier * levelPlus).setScale(0, RoundingMode.UP).doubleValue();
        //long pauseLong = (long) pauseDoubleTemp;
        for(int i = 0; i < 10; i++)
        {
            System.out.println((int)(startPause-levelPlus*(i+1)));
        }
    }

    public static void main(String[] args)
    {
        pause();
    }
}
