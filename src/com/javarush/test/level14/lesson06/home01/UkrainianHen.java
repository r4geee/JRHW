package com.javarush.test.level14.lesson06.home01;

/**
 * Created by r4geee on 24.06.2014.
 */
public class UkrainianHen extends Hen
{
    private int CountOfEggsPerMonth = 200;
    public int getCountOfEggsPerMonth()
    {
        return CountOfEggsPerMonth;
    }

    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}
