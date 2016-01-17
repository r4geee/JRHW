package MyTests;

/**
 * Created by Alexei on 17.01.2016.
 */
public class Person {
    private int age = 0;
    private String name = "Name";

    private Person() {
    }

    protected Person(int age) {
        this.age = age;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
