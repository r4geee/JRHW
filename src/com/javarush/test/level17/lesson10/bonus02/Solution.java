package com.javarush.test.level17.lesson10.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat dateFormatInput = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat dateFormatOutput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception
    {
        doAction(args);

        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String s = reader.readLine();
            String[] newCommand = s.split(" ");
            doAction(newCommand);
        }
        */



    }

    public static void doAction(String[] args) throws ParseException
    {
        if (args[0].charAt(0) == '-' && args[0].charAt(1) == 'c')
            createRecord(args);
        else if (args[0].charAt(0) == '-' && args[0].charAt(1) == 'u')
            updateRecord(args);
        else if (args[0].charAt(0) == '-' && args[0].charAt(1) == 'd')
            deleteRecord(args);
        else if (args[0].charAt(0) == '-' && args[0].charAt(1) == 'i')
            showRecord(args);
    }

    public static synchronized void createRecord(String[] args) throws ParseException
    {
        List<String> nameList = new ArrayList<String>();
        List<Sex> sexList = new ArrayList<Sex>();
        List<Date> dateList = new ArrayList<Date>();

        int[] dateIndexList = new int[10]; //индексы значений дат среди массива аргументов
        int datesTotal = 0;

        for (int i = 0; i < args.length; i++)
        {
            if (checkDate(args[i]))
            {
                dateIndexList[datesTotal] = i;
                datesTotal++;
            }
        }
        String tempName = new String();
        int datesCounter = 0;

        for (int i = 1; i < args.length; i++)
        {
            if (i != dateIndexList[datesCounter] && i != dateIndexList[datesCounter] - 1 && i != dateIndexList[datesCounter] - 2) //не поле даты, не поле пола, не поле последнего слова в имени
                tempName = tempName + args[i] + " ";
            else if (i != dateIndexList[datesCounter] && i != dateIndexList[datesCounter] - 1 && i == dateIndexList[datesCounter] - 2)
            {
                tempName = tempName + args[i];
                nameList.add(tempName);
            } else if (i == dateIndexList[datesCounter] - 1)
            {
                if (args[i].equals("м"))
                    sexList.add(Sex.MALE);
                else if (args[i].equals("ж"))
                    sexList.add(Sex.FEMALE);
            } else if (i == dateIndexList[datesCounter])
            {
                dateList.add(dateFormatInput.parse(args[i]));
                datesCounter++;
                tempName = "";
            }
        }
        //засовываем теперь в allPeople

        for (int i = 0; i < datesTotal; i++)
        {
            if (sexList.get(i).equals(Sex.MALE))
                allPeople.add(Person.createMale(nameList.get(i), dateList.get(i)));
            else if (sexList.get(i).equals(Sex.FEMALE))
                allPeople.add(Person.createFemale(nameList.get(i), dateList.get(i)));
            System.out.println(allPeople.size() - 1);
        }


    }

    public static synchronized void updateRecord(String[] args) throws ParseException
    {
        List<String> idList = new ArrayList<String>();
        List<String> nameList = new ArrayList<String>();
        List<Sex> sexList = new ArrayList<Sex>();
        List<Date> dateList = new ArrayList<Date>();

        int[] dateIndexList = new int[10]; //индексы значений дат среди массива аргументов
        int recordsTotal = 0;

        for (int i = 0; i < args.length; i++)
        {
            if (checkDate(args[i]))
            {
                dateIndexList[recordsTotal] = i;
                recordsTotal++;
            }
        }
        int[] idIndexList = new int[10]; //индексы значений ИД среди массива аргументов
        idIndexList[0] = 1;
        for (int i = 1; i < recordsTotal; i++)
        {
            idIndexList[i] = dateIndexList[i - 1] + 1;
        }

        String tempName = new String();

        int recordsCounter = 0; //обрабатываемая в данный момент запись

        for (int i = 1; i < args.length; i++)
        {
            if (i != dateIndexList[recordsCounter] && i != dateIndexList[recordsCounter] - 1 && i != dateIndexList[recordsCounter] - 2 && i != idIndexList[recordsCounter]) //не поле даты, не поле пола, не поле последнего слова в имени
                tempName = tempName + args[i] + " ";
            else if (i != dateIndexList[recordsCounter] && i != dateIndexList[recordsCounter] - 1 && i == dateIndexList[recordsCounter] - 2)
            {
                tempName = tempName + args[i];
                nameList.add(tempName);
            } else if (i == idIndexList[recordsCounter])
            {
                idList.add(args[i]);
            } else if (i == dateIndexList[recordsCounter] - 1)
            {
                if (args[i].equals("м"))
                    sexList.add(Sex.MALE);
                else if (args[i].equals("ж"))
                    sexList.add(Sex.FEMALE);
            } else if (i == dateIndexList[recordsCounter])
            {
                dateList.add(dateFormatInput.parse(args[i]));
                recordsCounter++;
                tempName = "";
            }
        }
        //обновляем записи

        for (int i = 0; i < recordsTotal; i++)
        {
            int id = Integer.parseInt(idList.get(i));
            String name = nameList.get(i);
            Sex sex = sexList.get(i);
            Date date = dateList.get(i);
            allPeople.get(id).setName(name);
            allPeople.get(id).setSex(sex);
            allPeople.get(id).setBirthDay(date);
        }


    }

    public static synchronized void deleteRecord(String[] args)
    {

        for (int i = 1; i < args.length; i++)
        {
            allPeople.get(Integer.parseInt(args[i])).setName(null);
            allPeople.get(Integer.parseInt(args[i])).setSex(null);
            allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
        }

    }

    public static synchronized void showRecord(String[] args)
    {

        for (int i = 1; i < args.length; i++)
        {
            Person shownPerson = allPeople.get(Integer.parseInt(args[i]));
            String sex = new String();
            if (shownPerson.getSex().equals(Sex.FEMALE))
                sex = "ж";
            else if (shownPerson.getSex().equals(Sex.MALE))
                sex = "м";
            System.out.println(shownPerson.getName() + " " + sex + " " + dateFormatOutput.format(shownPerson.getBirthDay()));
        }

    }

    public static boolean checkDate(String s)
    {
        try
        {
            dateFormatInput.parse(s);
            return true;
        }
        catch (ParseException e)
        {
            return false;
        }

    }


}
