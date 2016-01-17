package MyTests.raznoe;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSizeOfCreator {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество МБ");
        int MB = Integer.parseInt(bufferedReader.readLine());
        OutputStream outputStream = Files.newOutputStream(Paths.get("C:/big"));
        byte[] oneKB = new byte[1024];
        for (int i = 0; i < 1024; i++) {
            oneKB[i] = (byte) 128;
        }
        for (int i = 0; i < 1024 * MB; i++) {
            outputStream.write(oneKB);
        }
        outputStream.flush();
        outputStream.close();
        System.out.println("Файл размера " + MB + " МБ создан в C:/big");
    }

}
