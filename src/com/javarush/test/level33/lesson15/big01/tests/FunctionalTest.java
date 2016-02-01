package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ame on 1/29/2016.
 */
public class FunctionalTest {

    public void testStorage(Shortener shortener) {
        String s1 = "one";
        String s2 = "two";
        String s3 = "one";
        Long id1 = shortener.getId(s1);
        Long id2 = shortener.getId(s2);
        Long id3 = shortener.getId(s3);
        Assert.assertNotEquals(id1, id2);
        Assert.assertNotEquals(id3, id2);
        Assert.assertEquals(id1, id3);

        String newS1 = shortener.getString(id1);
        String newS2 = shortener.getString(id2);
        String newS3 = shortener.getString(id3);
        Assert.assertEquals(s1, newS1);
        Assert.assertEquals(s2, newS2);
        Assert.assertEquals(s3, newS3);
    }

    @Test
    public void testHashMapStorageStrategy() {
        testStorage(new Shortener(new HashMapStorageStrategy()));
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        testStorage(new Shortener(new OurHashMapStorageStrategy()));
    }

    @Test
    public void testFileStorageStrategy() {
        testStorage(new Shortener(new FileStorageStrategy()));
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        testStorage(new Shortener(new HashBiMapStorageStrategy()));
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        testStorage(new Shortener(new DualHashBidiMapStorageStrategy()));
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        testStorage(new Shortener(new OurHashBiMapStorageStrategy()));
    }
}
