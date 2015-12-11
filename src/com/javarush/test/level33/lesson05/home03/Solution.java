package com.javarush.test.level33.lesson05.home03;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


/* Десериализация JSON объекта
НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.4.3

В метод convertFromJsonToNormal первым параметром приходит имя файла, который содержит один ДЖЕЙСОН объект.
Вторым параметром приходит имя класса, объект которого находится в файле.
Метод convertFromJsonToNormal должен вычитать объект из файла, преобразовать его из JSON и вернуть его.
*/
public class Solution {

    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        Reader reader = new FileReader(fileName);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(reader, clazz);
    }
}
