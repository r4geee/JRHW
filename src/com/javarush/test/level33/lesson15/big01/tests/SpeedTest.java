package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alexei on 30.01.2016.
 */
public class SpeedTest {

    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date startOfIdsGenerationTime = new Date();
        for (String string : strings) {
            ids.add(shortener.getId(string));
        }
        Date endOfIdsGenerationTime = new Date();
        return endOfIdsGenerationTime.getTime() - startOfIdsGenerationTime.getTime();
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date startOfStringsGenerationTime = new Date();
        for (Long id : ids) {
            strings.add(shortener.getString(id));
        }
        Date endOfStringsGenerationTime = new Date();
        return endOfStringsGenerationTime.getTime() - startOfStringsGenerationTime.getTime();
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<Long> idSet1 = new HashSet<>();
        Set<Long> idSet2 = new HashSet<>();

        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        long shortener1IdGenerationTime = getTimeForGettingIds(shortener1, origStrings, idSet1);
        long shortener2IdGenerationTime = getTimeForGettingIds(shortener2, origStrings, idSet2);
        Assert.assertTrue(shortener1IdGenerationTime > shortener2IdGenerationTime);

        long shortener1StringsGenerationTime = getTimeForGettingStrings(shortener1, idSet1, new HashSet<String>());
        long shortener2StringsGenerationTime = getTimeForGettingStrings(shortener2, idSet2, new HashSet<String>());

        Assert.assertEquals(shortener1StringsGenerationTime, shortener2StringsGenerationTime, 5);
    }
}
