package com.javarush.test.level14.lesson06.home01;

/**
 * Created by r4geee on 24.06.2014.
 */
public class MoldovanHen extends Hen
{
    private int CountOfEggsPerMonth = 300;
    public int getCountOfEggsPerMonth()
    {
        return CountOfEggsPerMonth;
    }

    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}
