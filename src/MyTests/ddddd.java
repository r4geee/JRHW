package MyTests;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/**
 * Created by arostovshchikov on 11/7/2014.
 */
public class ddddd
{
    public static class SerTest implements Serializable, Cloneable
    {
        public static final long serialVersionUID = 2L;

        String name;
        public SerTest()
        {
            name = "done";
            System.out.println("constructor");
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutput objectOutput = new ObjectOutputStream(baos);
        SerTest serTest1 = new SerTest();
        objectOutput.writeObject(serTest1);

        SerTest copied = (SerTest) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject();
        System.out.println(copied.name);
        SerTest serTest = new SerTest();
        serTest.clone();
    }
}
