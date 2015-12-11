package com.javarush.test.level17.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
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

    public static void main(String[] args) throws IOException
    {
        String command = new String();

        for (int i = 0; i < args.length; i++)
        {
            if (i != args.length-1)
                command = command + args[i] + " ";
            else
                command = command + args[i];
        }
        doAction(command);
        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            command = reader.readLine();

            doAction(command);
        }
        */

    }

    public static void doAction(String command)
    {
        if (command.charAt(0) == '-' && command.charAt(1) == 'c')
            createRecord(command.substring(3));
        else if (command.charAt(0) == '-' && command.charAt(1) == 'u')
            updateRecord(command.substring(3));
        else if (command.charAt(0) == '-' && command.charAt(1) == 'd')
            deleteRecord(command.substring(3));
        else if (command.charAt(0) == '-' && command.charAt(1) == 'i')
            showRecord(command.substring(3));
    }

    public static void createRecord(String command)
    {
        try
        {
            String[] params = command.split(" ");
            String name = new String();
            for (int i = 0; i < params.length-2;i++)
            {
                if (i != params.length-3)
                    name = name + params[i] + " ";
                else
                    name = name + params[i];
            }
            String sex = params[params.length-2];
            String stringDate = params[params.length-1];

            if (sex.equals("м"))
                allPeople.add(Person.createMale(name, dateFormatInput.parse(stringDate)));
            else if (sex.equals("ж"))
                allPeople.add(Person.createFemale(name, dateFormatInput.parse(stringDate)));
            System.out.println(allPeople.size()-1);
        }
        catch (ParseException e)
        {

        }

    }

    public static void updateRecord(String command)
    {
        try
        {
            String[] params = command.split(" ");
            int id = Integer.parseInt(params[0]);
            String name = new String();
            for (int i = 1; i < params.length-2;i++)
            {
                if (i != params.length-3)
                    name = name + params[i] + " ";
                else
                    name = name + params[i];
            }
            String sex = params[params.length-2];
            String stringDate = params[params.length-1];

            allPeople.get(id).setName(name);

            if (sex.equals("м"))
                allPeople.get(id).setSex(Sex.MALE);
            else if (sex.equals("ж"))
                allPeople.get(id).setSex(Sex.FEMALE);

            allPeople.get(id).setBirthDay(dateFormatInput.parse(stringDate));
        }
        catch (ParseException e)
        {

        }
    }

    public static void deleteRecord(String id)
    {

        allPeople.get(Integer.parseInt(id)).setName(null);
        allPeople.get(Integer.parseInt(id)).setSex(null);
        allPeople.get(Integer.parseInt(id)).setBirthDay(null);

        //allPeople.remove(Integer.parseInt(id));
    }

    public static void showRecord(String id)
    {
        Person shownPerson = allPeople.get(Integer.parseInt(id));
        String sex = new String();
        if (shownPerson.getSex().equals(Sex.FEMALE))
            sex = "ж";
        else if (shownPerson.getSex().equals(Sex.MALE))
            sex = "м";
        System.out.println(shownPerson.getName() + " " + sex + " " + dateFormatOutput.format(shownPerson.getBirthDay()));
    }
}
