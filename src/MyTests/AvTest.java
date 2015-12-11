package MyTests;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by arostovshchikov on 11/7/2014.
 */
public class AvTest
{

    public static void main(String[] args) throws Exception
    {
        String path = "C:/3.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        System.out.println(fileInputStream.available());

        AsdQwe asdQwe = new AsdQwe();
    }
    static class AsdQwe {}

}


