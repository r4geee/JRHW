package com.javarush.test.level36.lesson06.task01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/* Найти класс по описанию
1. Реализует интерфейс List
2. Является приватным статическим классом внутри популярного утилитного класса
3. Доступ по индексу запрещен - кидается исключение IndexOutOfBoundsException
4. Используйте рефлекшн, чтобы добраться до искомого класса
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        String[] locations = getLocations();
        for (String location : locations) {
            if (location.endsWith(".jar")){
                try {
                    JarInputStream jarInputStream = new JarInputStream(Files.newInputStream(Paths.get(location)));
                    JarEntry jarEntry = jarInputStream.getNextJarEntry();
                    while (jarEntry != null) {
                        System.out.println(jarEntry.getName());
                        jarEntry = jarInputStream.getNextJarEntry();
                    }
                } catch (IOException e) {
                }
            }
        }
        return null;
/*        List<String> classNames = new ArrayList<>();
        try {
            JarInputStream jarInputStream = new JarInputStream(Files.newInputStream(Paths.get("C:\\Program Files\\Java\\jdk1.8.0_25\\jre\\lib\\rt.jar")));
            JarEntry jarEntry = jarInputStream.getNextJarEntry();
            while (jarEntry != null) {
*//*                if (jarEntry.getName().matches("java/util/[^/]*\\.class")) {
                    classNames.add(jarEntry.getName().replace("java/util/", "").replace(".class", ""));
                }*//*
                byte[] bytes = new byte[jarInputStream.available()];
                jarInputStream.read(bytes);

                jarEntry = jarInputStream.getNextJarEntry();
            }
        } catch (IOException e) {
        }

        List<Class<?>> classes = new ArrayList<>();

        for (String className : classNames) {
            try {
                classes.add(Class.forName("java.util." + className));
            }
            catch (ClassNotFoundException e) {

            }
        }
        for(Class<?> c : classes) {
            System.out.println(c);
        }
        return null;*/
    }

    public static String[] getLocations() {
        String classpath = System.getProperty("java.class.path");
        return classpath.split(System.getProperty("path.separator"));
    }
}
