package MyTests.raznoe;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Alexei on 13.01.2015.
 */
public class denomTest
{
    public static Map<Integer, Integer> denominations = new HashMap<>();
    public static void main(String[] args) throws NotEnoughMoneyException
    {
        denominations.put(500, 2);
        denominations.put(200, 2);
        //denominations.put(100, 1);
        //denominations.put(50, 12);

        Map<Integer, Integer> withdddd = withdrawAmount(600);
        for (Map.Entry<Integer, Integer> entry : withdddd.entrySet())
        {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }
    public static Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        List<Map<Integer, Integer>> list = new ArrayList<>();
        int bestMapIndex = 0;
        int mapDenominationsMinNumber = Integer.MAX_VALUE;
        Map<Integer, Integer> denominationsSorted = new TreeMap<>(Collections.reverseOrder());
        denominationsSorted.putAll(denominations);
        for (Map.Entry<Integer, Integer> entry : denominationsSorted.entrySet())
        {
            TreeMap<Integer, Integer> currentEntryIsMaxMap = new TreeMap<>(Collections.reverseOrder());
            for (Map.Entry<Integer, Integer> entry1 : denominations.entrySet())
            {
                if((entry1.getKey() <= entry.getKey()) && (entry1.getValue() != 0))
                {
                    currentEntryIsMaxMap.put(entry1.getKey(), entry1.getValue());
                }
            }
            Map<Integer, Integer> withDrawnMoney = new TreeMap<>(Collections.reverseOrder());
            while ((getTotalAmount(withDrawnMoney) < expectedAmount) && (currentEntryIsMaxMap.size() != 0))
            {
                int denomination = currentEntryIsMaxMap.firstKey();
                if (getTotalAmount(withDrawnMoney) + denomination > expectedAmount)
                {
                    currentEntryIsMaxMap.remove(denomination);
                    continue;
                }
                currentEntryIsMaxMap.put(denomination, currentEntryIsMaxMap.get(denomination) - 1);
                if (currentEntryIsMaxMap.get(denomination) == 0)
                {
                    currentEntryIsMaxMap.remove(denomination);
                }
                if(withDrawnMoney.get(denomination) != null)
                {
                    withDrawnMoney.put(denomination, withDrawnMoney.get(denomination) + 1);
                }
                else
                {
                    withDrawnMoney.put(denomination, 1);
                }
            }
            if (getTotalAmount(withDrawnMoney) == expectedAmount)
            {
                list.add(withDrawnMoney);
            }
        }
        if (list.size() == 0)
        {
            throw new NotEnoughMoneyException();
        }
        else
        {
            for (int i = 0; i < list.size(); i++)
            {
                int mapDenominationsNumber = Integer.MAX_VALUE;
                for (Map.Entry<Integer, Integer> entry : list.get(i).entrySet())
                {
                    mapDenominationsNumber += entry.getValue();
                }
                if (mapDenominationsNumber < mapDenominationsMinNumber)
                {
                    mapDenominationsMinNumber = mapDenominationsNumber;
                    bestMapIndex = i;
                }
            }
        }
        return list.get(bestMapIndex);
    }

    public static int getTotalAmount(Map<Integer, Integer> map)
    {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            sum += entry.getKey() * entry.getValue();
        }
        return sum;
    }
}
