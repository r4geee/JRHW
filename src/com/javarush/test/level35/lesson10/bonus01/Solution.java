package com.javarush.test.level35.lesson10.bonus01;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/* ClassLoader - что это такое?
Реализуйте логику метода getAllAnimals.
Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся скомпилированные классы.
Путь не обязательно содержит / в конце.
НЕ все классы наследуются от интерфейса Animal.
НЕ все классы имеют публичный конструктор без параметров.
Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров, - создать по одному объекту.
Добавить созданные объекты в результирующий сет и вернуть.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) {
        //Set<? extends Animal> allAnimals = getAllAnimals("out\\production\\JavaRushHomeWork\\com\\javarush\\test\\level35\\lesson10\\bonus01\\data");
        Set<? extends Animal> allAnimals = getAllAnimals("D:\\data");
        System.out.println(allAnimals);
    }
    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> animals = new HashSet<>();
        if (!pathToAnimals.endsWith("\\")) {
            pathToAnimals += "\\";
        }

        return animals;
    }
    public static Set<? extends Animal> getAllAnimals1(String pathToAnimals) {
        Set<Animal> animals = new HashSet<>();
        final String finalPathToAnimals;
        if (!pathToAnimals.endsWith("\\")) {
            finalPathToAnimals = pathToAnimals + "\\";
        } else {
            finalPathToAnimals = pathToAnimals;
        }

        class MyClassLoader extends ClassLoader {
            public MyClassLoader() {
                super(MyClassLoader.class.getClassLoader());
            }

            @Override
            public Class<?> findClass(String name) throws ClassNotFoundException {
                byte classByte[];
                Class result = null;
                try {
                    InputStream inputStream = Files.newInputStream(Paths.get(finalPathToAnimals + name));
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int l = 0;
                    while ((l = inputStream.read(buff)) > 0) {
                        byteArrayOutputStream.write(buff, 0, l);
                    }
                    classByte = byteArrayOutputStream.toByteArray();
                    result = defineClass("com.javarush.test.level35.lesson10.bonus01.data." + name.split("\\.")[0], classByte, 0, classByte.length, null);
                }
                catch (IOException e) {

                }
                return result;
            }
        }

        MyClassLoader classLoader = new MyClassLoader();

        List<String> fileNames = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(finalPathToAnimals))) {
            for (Path path : directoryStream) {
                if (path.getFileName().toString().endsWith(".class"))
                    fileNames.add(path.getFileName().toString());
            }
        }
        catch (IOException ex) {
        }

        for (String fileName : fileNames) {
            try {
                Class clazz = classLoader.findClass(fileName);
                Class[] interfaces = clazz.getInterfaces();
                if (Arrays.asList(interfaces).contains(Animal.class)) {
                    Constructor[] allConstructors = clazz.getDeclaredConstructors();
                    for (Constructor ctor : allConstructors) {
                        if (ctor.getParameterCount() == 0 && Modifier.isPublic(ctor.getModifiers()))
                            animals.add((Animal) clazz.newInstance());
                    }
                }
            }
            catch (ClassNotFoundException e) {
            }
            catch (InstantiationException e) {
            }
            catch (IllegalAccessException e) {

            }
        }
        return animals;
    }

    public static Set<? extends Animal> getAllAnimals2(String pathToAnimals) {
        if (!pathToAnimals.endsWith("/")) {
            pathToAnimals += "/";
        }

        List<File> fileList = new ArrayList<>();
        for (File file : Paths.get(pathToAnimals).toFile().listFiles()) {
            if (!file.isDirectory()) {
                fileList.add(file);
            }
        }

        try {

            URL url = Paths.get(pathToAnimals).toFile().toURL();
            URL[] urls = new URL[]{url};

            File newClassesDir = Paths.get(pathToAnimals + ".com.MyClasses").toFile();
            if (!newClassesDir.exists()) {
                newClassesDir.mkdirs();
            }
            ClassLoader classLoader = new URLClassLoader(urls);
            Class cl = classLoader.loadClass(".com.MyClasses");
        }
        catch (Exception e1) {
            e1.printStackTrace();
        }

        Set<? extends Animal> set = new HashSet<>();
        return set;
    }
}
