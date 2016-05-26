package MyTests;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alexei on 17.01.2016.
 */
public class Sss {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/DO NOT READ.txt");
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        System.out.println(new String(bytes));
    }
}
