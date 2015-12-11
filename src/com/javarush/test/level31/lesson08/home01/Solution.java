package com.javarush.test.level31.lesson08.home01;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* Null Object Pattern
Почитайте на вики про паттерн "Null Object"
Используйте Files, чтобы в конструкторе класса Solution правильно инициализировать поле fileData объектом ConcreteFileData.
Если возникли какие-то проблемы со чтением файла по пути pathToFile, то инициализируйте поле объектом NullFileData.
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        try {
            Path path = Paths.get(pathToFile);
            boolean isHidden = Files.isHidden(path);
            boolean isExecutable = Files.isExecutable(path);
            boolean isDirectory = Files.isDirectory(path);
            boolean isWritable = Files.isWritable(path);
            fileData = new ConcreteFileData(isHidden, isExecutable, isDirectory, isWritable);
        }
        catch (Exception e) {
            fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
