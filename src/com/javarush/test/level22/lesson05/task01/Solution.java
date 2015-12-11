package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution
{
    public static String getPartOfString(String string) throws TooShortStringException
    {
            if( string == null)
                throw new TooShortStringException();
            int firstSpaceIndex = string.indexOf(" ");
            int fourthSpaceIndex = firstSpaceIndex;
            for (int i = 0; i < 3; i++)
            {
                fourthSpaceIndex = string.indexOf(" ", fourthSpaceIndex + 1);
            }
            if (fourthSpaceIndex == string.length() || fourthSpaceIndex == -1)
                throw new TooShortStringException();
            StringBuilder s = new StringBuilder();
            s.append(string.substring(firstSpaceIndex+1, fourthSpaceIndex+1));
            if(string.substring(fourthSpaceIndex+1).contains(" "))
                s.append(string.substring(fourthSpaceIndex+1).split(" ")[0]);
            else
                s.append(string.substring(fourthSpaceIndex+1));
            return s.toString();

    }

    public static class TooShortStringException extends Exception
    {
    }


}
