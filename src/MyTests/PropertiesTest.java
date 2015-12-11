package MyTests;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by r4geee on 22.07.2014.
 */
public class PropertiesTest
{
    public static File file = new File("D:/properties.properties");
    public static void main(String[] args)
    {
        save();
        Properties pro = new Properties();
        try{
            FileInputStream in = new FileInputStream(file);
            pro.load(in);
            System.out.println("All keys of the property file : ");
            System.out.println(pro.keySet());
            System.out.println("All values of the property file : ");
            Enumeration em = pro.keys();
            while(em.hasMoreElements()){
                String str = (String)em.nextElement();
                System.out.println(str + ": " + pro.get(str));
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void load()
    {
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream(file);

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("database"));
            System.out.println(prop.getProperty("dbuser"));
            System.out.println(prop.getProperty("dbpassword"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void save()
    {

        Properties prop = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream(file);

            // set the properties value
            prop.setProperty("database", "localhost");
            prop.setProperty("dbuser", "mkyong");
            prop.setProperty("dbpassword", "password");

            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
