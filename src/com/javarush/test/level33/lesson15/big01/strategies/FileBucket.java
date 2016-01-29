package com.javarush.test.level33.lesson15.big01.strategies;

import com.javarush.test.level33.lesson15.big01.ExceptionHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Alexei on 24.01.2016.
 */
public class FileBucket {

    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(null, null);
            if (path.toFile().exists()) {
                remove();
            }
            Files.createFile(path);
            path.toFile().deleteOnExit();
        }
        catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

    public long getFileSize() {
        long result = 0;
        try {
            result =  Files.size(path);
        }
        catch (IOException e) {
            ExceptionHandler.log(e);
        }
        return result;
    }

    public void putEntry(Entry entry) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            objectOutputStream.writeObject(entry);
        }
        catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry() {
        Entry result = null;
        if (getFileSize() > 0) {

            try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path))) {
                result = (Entry) objectInputStream.readObject();
            }
            catch (IOException e) {
                ExceptionHandler.log(e);
            }
            catch (ClassNotFoundException e) {
                ExceptionHandler.log(e);
            }

        }
        return result;
    }

    public void remove() {
        try {
            Files.delete(path);
        }
        catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }
}
