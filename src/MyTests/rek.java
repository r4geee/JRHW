package MyTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alexei on 26.07.2015.
 */
public class rek
{
    static String[] array;
    static List<String> storage = new ArrayList<>();
    static List<List<String>> listList = new ArrayList<>();

    static {
        storage.add("1");
        storage.add("2");
        storage.add("3");
        storage.add("4");
    }
    public static void main(String[] args)
    {
        pickNum(new ArrayList<String>(), 0);
        for (List<String> list : listList)
        {
            System.out.println(list);
        }
        System.out.println(listList.size());
    }

    static void pickNum(List<String> list, int index) {
        List<String> listWith = new ArrayList<>(list);
        List<String> listWithOut = new ArrayList<>(list);
        listWith.add(storage.get(index));
        if (index == storage.size()-1) {
            listList.add(listWith);
            listList.add(listWithOut);
        }
        else {
            pickNum(listWith, index + 1);
            pickNum(listWithOut, index + 1);
        }
    }
}
