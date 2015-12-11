package com.javarush.test.level07.lesson09.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Буква «р» и буква «л»
1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1. удалять из списка строк все слова, содержащие букву «р»
2.2. удваивать все слова содержащие букву «л».
2.3. если слово содержит и букву «р» и букву «л», то оставить это слово без изменений.
Пример:
роза
лира
лоза
Выходные данные:
лира
лоза
лоза
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лира"); //1
        list.add("лоза"); //2

        list = fix(list);

        for (String s : list)
        {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        ArrayList<String> newList = new ArrayList<String>();

        for (int i = 0;i < list.size();i++)
        {
            String strWord = list.get(i);
            boolean boolHasR = false;
            boolean boolHasL = false;
            for (int y = 0; y < strWord.length(); y++ )
            {
                Character chrObject = strWord.charAt(y);
                char chrTemp = chrObject;
                if (chrTemp == 'р')
                {
                    boolHasR = true;
                }
                else if (chrTemp == 'л')
                {
                    boolHasL = true;
                }
            }
             if ((!boolHasR) && (boolHasL))
            {
                newList.add(strWord);
                newList.add(strWord);
            }
            else if ((boolHasR) && (boolHasL))
                newList.add(strWord);
             else if ((!boolHasR) && (!boolHasL))
                 newList.add(strWord);
        }
        return newList;
    }
}