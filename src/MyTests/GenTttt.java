package MyTests;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Alexei on 13.12.2015.
 */
public class GenTttt {
   /* public static void main(String[] args) throws ClassNotFoundException {
        //String folderPath = "out\\production\\JavaRushHomeWork\\com\\javarush\\test\\level35\\lesson10\\bonus01\\data";
        ClassLoader classLoader = GenTttt.class.getClassLoader();
        classLoader.

        Class<?> clazz = classLoader.loadClass("MyTests.Person");
        Constructor[] allConstructors = clazz.getDeclaredConstructors();
        for (Constructor ctor : allConstructors) {
*//*            Class<?>[] pType = ctor.getParameterTypes();
            System.out.println("pType size = " + pType.length);*//*
            System.out.println(ctor.getParameterCount());
            if(Modifier.isPublic(ctor.getModifiers()))
                System.out.println("isPublic");
            if(Modifier.isPrivate(ctor.getModifiers()))
                System.out.println("isPrivate");
            if(Modifier.isProtected(ctor.getModifiers()))
                System.out.println("isProtected");
        }
    }*/
}
