package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;
    public static final long serialVersionUID = 1L;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.flush();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception
    {
        Solution s = new Solution("C:/output.txt");
        s.writeObject("Привет");
        s.writeObject("Привет2");
        s.writeObject("Привет3");

        ByteArrayOutputStream storage = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(storage);
        objectOutputStream.writeObject(s);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(storage.toByteArray()));
        Solution read = (Solution) objectInputStream.readObject();
        read.writeObject("Hello");
        read.writeObject("Hello2");
        read.writeObject("Hello3");
        read.close();
    }
}
