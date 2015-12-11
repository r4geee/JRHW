package MyTests;

import com.javarush.test.level23.lesson04.task02.Solution;

/**
 * Created by Alexei on 30.11.2014.
 */
public class accesstest
{
    public static void main(String[] args)
    {
        Solution solution = new Solution("the USA", "Seattle");
        //внутри класса Solution (а сейчас мы внутри) к методу getDescription можно обращаться обоими способами
        //System.out.println(solution.getTrickyUser("George").getDescription());
        //а из любого другого внешнего класса только так:
        System.out.println(solution.getDescriptionOfUser("George"));
    }
}
