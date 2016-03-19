package com.javarush.test.level36.lesson10.bonus01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* Осваиваем ClassLoader и Reflection
Аргументом для класса Solution является абсолютный путь к пакету,
например, "C:\JavaRushHomeWork\src\com\javarush\test\level36\lesson10\bonus01\data\second".
Имя пакета может содержать File.separator.
В этом пакете находятся только скомпилированные классы.
Известно, что каждый класс имеет конструктор без параметров и реализует интерфейс HiddenClass.
Считайте все классы с файловой системы, создайте фабрику - реализуйте метод getHiddenClassObjectByKey.
Известно, что есть только один класс, простое имя которого начинается с String key без учета регистра.
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;
    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //Solution solution = new Solution("C:\\JavaRushHomeWork\\src\\com\\javarush\\test\\level36\\lesson10\\bonus01\\data\\second");
        Solution solution = new Solution("D:\\Documents\\Dropbox\\Workspace\\IDEA\\JavaRushHomeWork\\out\\production\\JavaRushHomeWork\\com\\javarush\\test\\level36\\lesson10\\bonus01\\data\\second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        final String finalPackageName;
        if (!packageName.endsWith("/")) {
            finalPackageName =  packageName +  "/";
        } else {
            finalPackageName = packageName;
        }

        List<String> fileNames = new ArrayList<>();
        for (File file : new File(finalPackageName).listFiles()) {
            if (file.isFile() && file.getName().endsWith(".class"))
                fileNames.add(file.getName());
        }

        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> findClass(String className) throws ClassNotFoundException
            {
                try
                {
                    byte b[] = readBytes(finalPackageName + className + ".class");
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
            try {
                hiddenClasses.add(classLoader.loadClass(className));
            } catch (Exception e) {

            }
        }
    }

    public  byte[] readBytes(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        return bytes;
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        for (Class clazz : hiddenClasses) {
            if (HiddenClass.class.isAssignableFrom(clazz) && clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())){
                try {
                    Constructor<HiddenClass> constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    return constructor.newInstance();
                }
                catch (InstantiationException e) {
                }
                catch (IllegalAccessException e) {

                }
                catch (NoSuchMethodException e) {

                }
                catch (InvocationTargetException e) {

                }
            }
        }
        return null;
    }
}