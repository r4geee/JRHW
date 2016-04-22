package MyTests;


import sun.misc.BASE64Encoder;

import java.io.*;

public class ImageToBase64 {
    public static void main(String[] args) throws IOException {
        String url = "D:/1.png";
        //String url = "C:\\Users\\ame\\Desktop\\c1_logo_small.png";
        InputStream inputStream = new FileInputStream(url);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        BASE64Encoder encoder = new BASE64Encoder();
        String base64String = encoder.encode(bytes);
        System.out.println(base64String);
        OutputStream outputStream = new FileOutputStream(url.replace("\\..*", ".txt"));
        outputStream.write(base64String.getBytes());
        inputStream.close();
        outputStream.flush();
        outputStream.close();
    }
/*    public static void main(String[] args)  {
        try {
            String url = "C:\\Users\\ame\\Desktop\\c1_logo_small.png";
            InputStream inputStream = new FileInputStream(url);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            String base64String = Base64.encode(bytes);
            System.out.println(base64String);
            OutputStream outputStream = new FileOutputStream(url.replace("\\..*", ".txt"));
            outputStream.write(base64String.getBytes());
            inputStream.close();
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/
}