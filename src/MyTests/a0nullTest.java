package MyTests;

/**
 * Created by arostovshchikov on 10/10/2014.
 */
public class a0nullTest
{
    public static void main(String[] args)
    {
        A a = new A();
        B b = new B(a.s1);
        a.s1 = "lol2";
        System.out.println(b.s2);
    }


    public static class A
    {
        String s1;

        public A()
        {
            this.s1 = "lol1";
        }
    }

    public static class B
    {
        String s2;
        public B(String s2)
        {
            this.s2 = s2;
        }
    }
}

class Ass
{

}
