package MyTests.test1.testpac;

/**
 * Created by Alexei on 10.05.2015.
 */
public class Cccc
{
    public static void main(String[] args)
    {
        new Cccc().f();
    }

    public void f()
    {
        System.out.println("./src/" + this.getClass().getPackage().toString().replace("package ", "").replace(".", "/") + "/vacancies.html");
    }
}
