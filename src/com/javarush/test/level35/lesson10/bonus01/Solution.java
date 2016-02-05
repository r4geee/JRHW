package com.javarush.test.level35.lesson10.bonus01;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
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
        Set<? extends Animal> allAnimals = getAllAnimals("D:/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        if (!pathToAnimals.endsWith("/")) {
            pathToAnimals += "/";
        }

        Set<Animal> animals = new HashSet<>();
        try {
            URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL("file:"+pathToAnimals)});
            List<String> fileNames = new ArrayList<>();
            for (File file : new File(pathToAnimals).listFiles()) {
                if (file.getName().endsWith(".class"))
                    fileNames.add(file.getName());
            }
            for (String fileName : fileNames) {
                String className = fileName.split("\\.class")[0];
                Class clazz = urlClassLoader.loadClass("com.javarush.test.level35.lesson10.bonus01.data." + className);
                //Class clazz = urlClassLoader.loadClass(className);
                try {
                    Animal instance = (Animal) clazz.newInstance();
                    animals.add(instance);
                } catch (Exception e) {

                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return animals;
    }
}
