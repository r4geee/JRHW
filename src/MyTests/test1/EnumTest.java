package MyTests.test1;

/**
 * Created by Test on 1/14/2015.
 */
public enum EnumTest
{
    ODIN("1"),
    DVA("2"),
    TRI("3");

    public String name;

    EnumTest(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public static String allDishesToString()
    {
        StringBuilder sb = new StringBuilder();
        for (EnumTest dish : EnumTest.values())
        {
            sb.append(dish.name() + ", ");
        }
        if (sb.length() != 0)
        {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }
}
