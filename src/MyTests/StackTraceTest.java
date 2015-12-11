package MyTests;

/**
 * Created by r4geee on 07.06.2014.
 */
public class StackTraceTest
{
    public static void main(String[] args) throws Exception
    {
        method1();
    }

    public static int method1()
    {
        method2();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int result = stackTraceElements[2].getLineNumber();
        return result;
    }

    public static int method2()
    {
        method3();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int result = stackTraceElements[2].getLineNumber();
        return result;
    }

    public static int method3()
    {
        method4();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int result = stackTraceElements[2].getLineNumber();
        return result;
    }

    public static int method4()
    {
        method5();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int result = stackTraceElements[2].getLineNumber();
        return result;
    }

    public static int method5()
    {
        getStackTraceDeep();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int result = stackTraceElements[2].getLineNumber();
        return result;
    }

    public static int getStackTraceDeep()
    {

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int elementNumber = stackTraceElements.length;
        System.out.println(elementNumber);
        return elementNumber;

    }
}
