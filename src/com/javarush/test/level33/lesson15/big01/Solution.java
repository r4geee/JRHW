package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.FileStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.OurHashMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alexei on 17.01.2016.
 */
public class Solution {

    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10000);
        testStrategy(new OurHashMapStorageStrategy(), 10000);
        testStrategy(new FileStorageStrategy(), 1000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> ids = new HashSet<>();
        for (String string : strings) {
            ids.add(shortener.getId(string));
        }
        return ids;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> strings = new HashSet<>();
        for (Long key : keys) {
            strings.add(shortener.getString(key));
        }
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> testStringSet = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            testStringSet.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        Date startOfIdsGenerationTime = new Date();
        Set<Long> ids = getIds(shortener, testStringSet);
        Date endOfIdsGenerationTime = new Date();
        System.out.println(endOfIdsGenerationTime.getTime() - startOfIdsGenerationTime.getTime());

        Date startOfStringsGenerationTime = new Date();
        Set<String> returnedStringSet = getStrings(shortener, ids);
        Date endOfStringsGenerationTime = new Date();
        System.out.println(endOfStringsGenerationTime.getTime() - startOfStringsGenerationTime.getTime());

        if (testStringSet.equals(returnedStringSet)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }
}
