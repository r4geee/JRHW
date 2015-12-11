package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution
{
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args)
    {
        try
        {
            String tag = args[0];
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String path = reader.readLine();
            FileInputStream fileInputStream = new FileInputStream(path);
            ByteArrayOutputStream buf = new ByteArrayOutputStream();

            while (fileInputStream.available() > 0)
            {
                int data = fileInputStream.read();
                buf.write(data);
            }
            String inputData = buf.toString();

            extractTags(inputData);
            String result = "";

            for (String s : list)
            {
                s = clearSpacesAndNewLines(s);
                String openingTag = s.split(">")[0].replaceAll("<", "");
                String[] temp1 = s.split("</");
                String[] temp2 = temp1[temp1.length - 1].split(">");
                String closingTag = temp2[0];
                if (closingTag.equals(tag) && openingTag.matches(tag + "[^\\>]*"))
                {
                    result = result + s + System.lineSeparator();
                }
            }
            if (!result.equals(""))
            {
                result = result.substring(0, result.length() - 1);
                System.out.println(result);
            }
            reader.close();
            fileInputStream.close();
            buf.close();
        }
        catch (IOException e)
        {

        }

    }

    public static void extractTags(String inputData)
    {
        String part1 = "";
        String part2 = "";
        for (int i = 1; i < inputData.length(); i++)
        {
            String subInputData = inputData.substring(0, i + 1);
            int openingTagsNumber = tagCountInString(subInputData, "opening");
            int closingTagsNumber = tagCountInString(subInputData, "closing");
            if ((openingTagsNumber != closingTagsNumber) || (openingTagsNumber == 0 && closingTagsNumber == 0))
            {
                continue;
            }
            int partEndIndex = inputData.indexOf(">", i);
            part1 = inputData.substring(0, partEndIndex + 1);
            if (partEndIndex != inputData.length())
                part2 = inputData.substring(partEndIndex + 1, inputData.length());
            break;
        }
        if (part1 == "")
            return;
        int a = part1.indexOf("<");
        int b = part1.indexOf(">");
        int c = part1.lastIndexOf("<");
        int d = part1.lastIndexOf(">");
        String openingTag = inputData.substring(a, b + 1);
        String closingTag = inputData.substring(c, d + 1);
        String data = inputData.substring(b + 1, c);
        list.add(openingTag + data + closingTag);
        if (data.contains("<") && data.contains(">"))
            extractTags(data);

        if (part2.contains("<") && part2.contains(">"))
            extractTags(part2);
    }

    public static int tagCountInString(String s, String element)
    {
        int count = 0;
        String regex = "";
        if (element.equals("opening"))
            regex = "<[^/][^>]*>";
        else if (element.equals("closing"))
            regex = "</[^>]*>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find())
            count++;
        return count;
    }

    public static String clearSpacesAndNewLines (String s)
    {
        Pattern pattern;
        Matcher matcher;
        String tagRegex = "<(?:\"[^\"]*\"['\"]*|'[^']*'['\"]*|[^'\">])+>";
        pattern = Pattern.compile(tagRegex);
        matcher = pattern.matcher(s);
        while (matcher.find())
        {
            String toFixPart = matcher.group();
            String fixedPart = toFixPart.replaceAll(System.lineSeparator(), " ").replaceAll("[\\s]+", " ").replaceAll(" \\>", "\\>");
            s = s.replaceAll(toFixPart, fixedPart);
        }
        s = s.replaceAll(System.lineSeparator(), "");
        return s;
    }
}
