package MyTests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by r4geee on 24.08.2014.
 */
public class Raw
{
    public static void main(String[] args)
    {
        List rawList = new ArrayList();
        List<String> list = new ArrayList<>();

        rawList = list;
        rawList.add(8);

        String s = list.get(0);
        System.out.println(rawList.get(0));
    }
}
