package MyTests.raznoe;

/**
 * Created by r4geee on 21.08.2014.
 */
public class Outer
{
    int a = 5;
    public class Inner
    {
        int a = 6;

        public int getOne()
        {
            return this.a;
        }

        public int getTwo()
        {
            return Outer.this.a;
        }

        public int getThree()
        {
            return Outer.Inner.this.a;
        }
    }

    public static void main(String[] args)
    {
        Inner inner = new Outer().new Inner();
        System.out.println(inner.getOne());
        System.out.println(inner.getTwo());
        System.out.println(inner.getThree());
    }
}
