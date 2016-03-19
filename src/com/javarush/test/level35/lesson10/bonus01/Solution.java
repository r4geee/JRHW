package com.javarush.test.level35.lesson10.bonus01;

import com.javarush.test.level35.lesson10.bonus01.data.Cat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
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
        Set<? extends Animal> allAnimals = getAllAnimals("D:\\Documents\\Dropbox\\Workspace\\IDEA\\JavaRushHomeWork\\out\\production\\JavaRushHomeWork\\com\\javarush\\test\\level35\\lesson10\\bonus01\\data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        final String finalPathToAnimals;
        if (!pathToAnimals.endsWith("/")) {
            finalPathToAnimals =  pathToAnimals +  "/";
        } else {
            finalPathToAnimals = pathToAnimals;
        }

        Set<Animal> result = new HashSet<>();

        List<String> fileNames = new ArrayList<>();
        for (File file : new File(pathToAnimals).listFiles()) {
            if (file.isFile() && file.getName().endsWith(".class"))
                fileNames.add(file.getName());
        }
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> findClass(String className) throws ClassNotFoundException
            {
                try
                {
                    byte b[] = readBytes(finalPathToAnimals + className + ".class");
                    return defineClass(null, b, 0, b.length);
                }
                catch (FileNotFoundException ex)
                {
                    return super.findClass(className);
                }
                catch (IOException ex)
                {
                    return super.findClass(className);
                }
            }
        };

        for (String fileName : fileNames) {
            String className = fileName.split("\\.class")[0];
            Class clazz = null;
            try {
                clazz = classLoader.loadClass(className);

                boolean hasConstructor = false;
                Constructor[] constructors = clazz.getConstructors();
                for (Constructor c : constructors)
                {
                    if( Modifier.isPublic(c.getModifiers()) && c.getParameterTypes().length==0 )
                    {
                        hasConstructor = true;
                        break;
                    }
                }
                if (!hasConstructor) {
                    throw new Exception();
                }
                Object o = clazz.newInstance();
                if (!(o instanceof Animal)) {
                    throw new Exception();
                }

                result.add((Animal) o);
            } catch (Exception e) {

            }
        }

        return result;
    }

    public static byte[] readBytes(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        return bytes;
    }
}
