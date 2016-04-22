package MyTests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * Created by Alexei on 13.12.2015.
 */
public class GenTttt {
    public static void main(String[] args) {
        String regex = ".*407.*";
        String s = "00407-121-313";
        System.out.println(s.matches(regex));;
    }
}
