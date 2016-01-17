package MyTests.raznoe;

/**
 * Created by r4geee on 05.08.2014.
 */
public class ClassDemo implements Cloneable
{
    @Override
    protected ClassDemo clone() throws CloneNotSupportedException
    {
        return (ClassDemo) super.clone();
    }
}
