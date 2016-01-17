package MyTests.raznoe;

/**
 * Created by r4geee on 07.07.2014.
 */
public class ArgsTest
{
    public static void main(String[] args)
    {
        Charochkin Stas = new Charochkin("Stasik", 26, true);
        System.out.println(Stas.name);
    }
}

class Charochkin
{
    String name;
    int age;
    boolean durak;

    public Charochkin(String name, int age, boolean durak)
    {
        this.name = name;
        this.age = age;
        this.durak = durak;
    }
}