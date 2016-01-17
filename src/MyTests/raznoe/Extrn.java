package MyTests.raznoe;

import java.io.*;

/**
 * Created by arostovshchikov on 29/7/2014.
 */
public class Extrn
{
    public static class Cat implements Externalizable
    {
        //public static final long serialVersionUID = 170501996;
        public String name;
        public int age;

 /*       public Cat()
        {
            super();
        }*/

/*        public Cat(String name, int age)
        {
            this.name = name;
            this.age = age;
        }*/

        @Override
        public void writeExternal(ObjectOutput out) throws IOException
        {
            out.writeObject(name);
            out.writeInt(age);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
        {
            name = (String) in.readObject();
            age = in.readInt();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Cat cat = new Cat();
        cat.name = "Lalkf";
        cat.age = 555;
        FileOutputStream fileOutputStream = new FileOutputStream("C:/temp.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        cat.writeExternal(objectOutputStream);
        objectOutputStream.close();
        fileOutputStream.close();

        Cat newCat = new Cat();
        FileInputStream fileInputStream = new FileInputStream("C:/temp.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        newCat.readExternal(objectInputStream);
        System.out.println(newCat.name + " " + newCat.age);
        objectInputStream.close();
        fileInputStream.close();
    }
}
