package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {

    public static final List<File> list = new ArrayList<>();
    public static File result;
    public static File mainPath;

    public static void main(String[] args) {
        mainPath = new File(args[0]);
        result = new File(args[1]);
        deleteBigFiles(mainPath);
        Collections.sort(list, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        File renamed = new File(result.getParent() + "/allFilesContent.txt");
        result.renameTo(renamed);
        writeResult(renamed);
        deleteEmptyFolders(mainPath);
    }

    public static void deleteBigFiles(File path) {
        for (File file : path.listFiles()) {
            if (file.getAbsolutePath().equals(result.getAbsolutePath())) {
                continue;
            } else if (file.isDirectory()) {
                deleteBigFiles(file);
            } else if (file.length() > 50) {
                file.delete();
            } else {
                list.add(file);
            }
        }
    }

    public static void deleteEmptyFolders(File path) {
        for (File file : path.listFiles()) {
            if (file.isDirectory()) {
                deleteEmptyFolders(file);
            }
        }
        if (path.listFiles().length == 0 && !path.getAbsolutePath().equals(mainPath.getAbsolutePath())) {
            path.delete();
        }
    }

    public static void writeResult(File result) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(result)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                try (FileInputStream fileInputStream = new FileInputStream(list.get(i))) {
                    byte[] buffer = new byte[fileInputStream.available()];
                    fileInputStream.read(buffer);
                    sb.append(new String(buffer));
                    if (i != list.size() - 1) {
                        sb.append(System.lineSeparator());
                    }
                }
            }
            fileOutputStream.write(sb.toString().getBytes());
        }
        catch (IOException e) {

        }
    }
}
