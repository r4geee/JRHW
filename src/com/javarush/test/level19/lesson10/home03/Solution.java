package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException
    {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader readerF = new BufferedReader(fileReader);
        SimpleDateFormat ft = new SimpleDateFormat("dd MM yyyy");
        while (readerF.ready())
        {
            String[] s = readerF.readLine().split(" ");
            String name = "";
            int  totalParams = s.length;
            int paramsRead = 4;
            int day = Integer.parseInt(s[totalParams-3]);
            int month = Integer.parseInt(s[totalParams-2]);
            int year = Integer.parseInt(s[totalParams-1]);
            while (totalParams-paramsRead >= 0)
            {
                if (paramsRead == 4)
                    name = s[totalParams - paramsRead] + name;
                else
                    name = s[totalParams - paramsRead] + " " + name;
                paramsRead++;
            }
            String strTempDate = day + " " + month + " " + year;
            Date date = ft.parse(strTempDate);
            PEOPLE.add(new Person(name, date));
        }

        //for (Person person : PEOPLE)
        //    System.out.println(person.getName()+ " " + ft.format(person.getBirthday()));

        fileReader.close();
        readerF.close();
    }

}
