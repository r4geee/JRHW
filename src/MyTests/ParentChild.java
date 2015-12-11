package MyTests;

/**
 * Created by r4geee on 17.07.2014.
 */
public class ParentChild
{
    public static void main(String[] args)
    {
        Parent p = new GrandChild();
        System.out.println(p.a);
        p.say("asd");

    }

    public static class Parent
    {
        private int a = 5;
        public void say(String s)
        {
            System.out.println(s);
        }
    }

    public static class Child extends Parent
    {
        @Override
        public void say(String s)
        {
            //super.say(s);
            System.out.println("Im Child");
        }
    }

    public static class GrandChild extends Child
    {
        public int a;
        @Override
        public void say(String s)
        {
            //super.say(s);
            System.out.println("Im grandChild");
        }

        public void sayLOL()
        {
            System.out.println("LOL");
        }
    }

}
