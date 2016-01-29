package MyTests;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexei on 13.12.2015.
 */
public class GenTttt {
    public static void main(String[] args) throws ClassNotFoundException {
        Path currentDir = Paths.get(".");
        System.out.println(currentDir.toAbsolutePath());
    }
}
