package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Alexei on 26.12.2014.
 */
public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
        denominations = new HashMap<>();
    }

    public void addAmount(int denomination, int count)
    {
        if(denominations.get(denomination) != null)
        {
            denominations.put(denomination, denominations.get(denomination) + count);
        }
        else
        {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount()
    {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet())
        {
            sum += entry.getKey() * entry.getValue();
        }
        return sum;
    }
    
    public boolean hasMoney()
    {
        return getTotalAmount() > 0;
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        try
        {
            Map<Integer, Integer> result = null;
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
                    if ((entry1.getKey() <= entry.getKey()) && (entry1.getValue() != 0))
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
                    if (withDrawnMoney.get(denomination) != null)
                    {
                        withDrawnMoney.put(denomination, withDrawnMoney.get(denomination) + 1);
                    } else
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
            } else
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
            result = list.get(bestMapIndex);
            for (Map.Entry<Integer, Integer> entry : result.entrySet())
            {
                int newNumber = 0;
                newNumber = denominations.get(entry.getKey()) - entry.getValue();
                if (newNumber != 0)
                {
                    denominations.put(entry.getKey(), newNumber);
                }
                else
                {
                    denominations.remove(entry.getKey());
                }
            }
            return result;
        }
        catch (ConcurrentModificationException e)
        {
            return new TreeMap<>();
        }
    }

    public int getTotalAmount(Map<Integer, Integer> map)
    {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            sum += entry.getKey() * entry.getValue();
        }
        return sum;
    }
}
