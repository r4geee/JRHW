package MyTests;

import java.util.Arrays;

/**
 * Created by Alexei on 17.01.2016.
 */
public class Sss {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName("java.util.Arrays.ArrayList");
        Object o = clazz.newInstance();
        System.out.println(o);
    }
}
