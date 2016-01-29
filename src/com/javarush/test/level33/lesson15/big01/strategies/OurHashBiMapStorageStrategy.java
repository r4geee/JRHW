package com.javarush.test.level33.lesson15.big01.strategies;

import java.util.HashMap;

/**
 * Created by ame on 1/29/2016.
 */
public class OurHashBiMapStorageStrategy implements StorageStrategy {

    private HashMap<Long, String> k2v = new HashMap<>();
    private HashMap<String, Long> v2k = new HashMap<>();
    @Override
    public boolean containsKey(Long key) {
        if (key != null) {
            return k2v.containsKey(key);
        }
        return false;
    }

    @Override
    public boolean containsValue(String value) {
        if (value != null) {
            return v2k.containsKey(value);
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        if (key != null && value != null)
            k2v.put(key, value);
            v2k.put(value, key);
    }

    @Override
    public Long getKey(String value) {
        if (value != null && containsValue(value)){
            return v2k.get(value);
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        if (key != null && containsKey(key)){
            return k2v.get(key);
        }
        return null;
    }
}
