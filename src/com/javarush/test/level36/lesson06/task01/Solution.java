package com.javarush.test.level36.lesson06.task01;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
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
            if (location.endsWith(".jar")) {
                try {
                    JarInputStream jarInputStream = new JarInputStream(Files.newInputStream(Paths.get(location)));
                    JarEntry jarEntry = jarInputStream.getNextJarEntry();
                    while (jarEntry != null) {
                        try {
                            String className = jarEntry.getName().replaceAll("/", ".").replaceAll(".class", "");
                            if (!className.startsWith("java.util")) {
                                jarEntry = jarInputStream.getNextJarEntry();
                                continue;
                            }
                            Class<?> clazz = Class.forName(className);
                            int modifiers = clazz.getModifiers();
                            if (List.class.isAssignableFrom(clazz) && Modifier.isPrivate(modifiers) && Modifier.isStatic(modifiers)) {
 /*                               Constructor<?> constructor =  clazz.getDeclaredConstructor();
                                constructor.setAccessible(true);
                                System.out.println("1");
                                List list = (List) constructor.newInstance(0, new Object());
                                list.add(new Object());
                                try {
                                    System.out.println("1");
                                    list.get(0);
                                }
                                catch (IndexOutOfBoundsException e) {
                                    return clazz;
                                }*/
                                System.out.println(clazz.getName());
                            }
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                        jarEntry = jarInputStream.getNextJarEntry();
                    }

                }
                catch (IOException e) {

                }
            }
        }
        return Collections.EMPTY_LIST.getClass();

    }

    public static String[] getLocations() {
        String classpath = System.getProperty("java.class.path");
        return classpath.split(System.getProperty("path.separator"));
    }
}
