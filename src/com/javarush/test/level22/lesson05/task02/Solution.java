package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string == null)
            throw new TooShortStringException();
        int indexOfFirstTab = string.indexOf("\t");
        int indexOfSecondTab = string.indexOf("\t", indexOfFirstTab+1);
        if (indexOfFirstTab == -1 || indexOfSecondTab == -1 )
            throw new TooShortStringException();
        return string.substring(indexOfFirstTab+1,indexOfSecondTab);
    }

    public static class TooShortStringException extends Exception {
    }
}
