package com.javarush.test.level14.lesson06.home01;

/**
 * Created by r4geee on 24.06.2014.
 */
public class BelarusianHen extends Hen
{
    private int CountOfEggsPerMonth = 1000;
    public int getCountOfEggsPerMonth()
    {
        return CountOfEggsPerMonth;
    }
    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}
