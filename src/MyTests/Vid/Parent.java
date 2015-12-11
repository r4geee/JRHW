package MyTests.Vid;

/**
 * Created by Alexei on 28.11.2015.
 */
public class Parent {

    public void f1() {
        f2();
        f3();
    }

    private void f2() {
        System.out.println("f2");
    }
    private void f3() {
        System.out.println("f3");
    }
}
