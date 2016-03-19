package MyTests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * Created by Alexei on 13.12.2015.
 */
public class GenTttt {
    public static void main(String[] args) {
        final String JAVA_HOME = System.getenv("JAVA_HOME");
        try {
            JarInputStream jarInputStream = new JarInputStream(Files.newInputStream(Paths.get(JAVA_HOME + "\\jre\\lib\\rt.jar")));
            JarEntry jarEntry = jarInputStream.getNextJarEntry();
            while (jarEntry != null) {
/*                if (jarEntry.getName().matches("java/util/[^/]*\\.class")) {
                    classNames.add(jarEntry.getName().replace("java/util/", "").replace(".class", ""));
                }*/
/*                if (jarEntry.getName().matches("java/util/[^/]*\\.class")) {
                    System.out.println(jarEntry.getName());
                }*/
                System.out.println(jarEntry.getName());
                jarEntry = jarInputStream.getNextJarEntry();
            }
        } catch (IOException e) {
        }
    }
}
