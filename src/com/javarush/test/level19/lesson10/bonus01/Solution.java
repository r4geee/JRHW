package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();
        BufferedReader readerFile1 = new BufferedReader(new FileReader(path1));
        BufferedReader readerFile2 = new BufferedReader(new FileReader(path2));

        List<String> file1Lines = new ArrayList<>();
        List<String> file2Lines = new ArrayList<>();
        while (readerFile1.ready())
        {
            file1Lines.add(readerFile1.readLine());
        }

        while (readerFile2.ready())
        {
            file2Lines.add(readerFile2.readLine());
        }

        int file1iT = 0;
        int file2iT = 0;

        while(file1iT != file1Lines.size() && file2iT != file2Lines.size())
        {
            String file1Element = file1Lines.get(file1iT);
            String file2Element = file2Lines.get(file2iT);

            String file2NextElement = "";

            if (file2iT != file2Lines.size()-1)
                file2NextElement = file2Lines.get(file2iT+1);

            if (!file2Element.equals(file1Element) && !file2NextElement.equals(file1Element))
            {
                lines.add(new LineItem(Type.REMOVED, file1Element));
                file1iT++;
            }
            else if (file2Element.equals(file1Element))
            {
                lines.add(new LineItem(Type.SAME, file1Element));
                file1iT++;
                file2iT++;
            }
            else if (!file2Element.equals(file1Element) && file2NextElement.equals(file1Element))
            {
                lines.add(new LineItem(Type.ADDED, file2Element));
                file2iT++;
            }
            if (file1iT != file1Lines.size())
                file1Element = file1Lines.get(file1iT);
            if (file2iT != file2Lines.size())
                file2Element = file2Lines.get(file2iT);

            if (file1iT != file1Lines.size() && file2iT == file2Lines.size())
            {
                lines.add(new LineItem(Type.REMOVED, file1Element));
                file1iT++;
            }
            else if (file1iT == file1Lines.size() && file2iT != file2Lines.size())
            {
                lines.add(new LineItem(Type.ADDED, file2Element));
                file2iT++;
            }
        }

        for (LineItem lineItem : lines)
        {
            System.out.println(lineItem.type + " " + lineItem.line);
        }

        reader.close();
        readerFile1.close();
        readerFile2.close();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
