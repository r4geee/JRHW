package MyTests.raznoe;

import com.javarush.test.level31.lesson15.big01.FileManager;
import com.javarush.test.level31.lesson15.big01.FileProperties;
import com.javarush.test.level31.lesson15.big01.exception.PathIsNotFoundException;

import java.io.*;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


public class aaaa {

    public static void main(String[] args) throws Exception {
        String s = "(123) 456-7890";
        String s1 = "(123)456-7890";
        boolean res = s1.matches("\\([0-9]{3}\\)\\s?[0-9]{3}-[0-9]{4}");
        System.out.println(res);
    }
}