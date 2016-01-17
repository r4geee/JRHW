package MyTests.raznoe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by r4geee on 09.08.2014.
 */
public class TryWResTest
{
    public static void main(String[] args)
    {
        readFile("D:/1.txt");

    }

    public static void readFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            System.out.println(br.readLine());
        } catch (FileNotFoundException ignored) {
        } catch (IOException ignored) {

        } finally {
            System.out.println("finally");
        }
    }
}
