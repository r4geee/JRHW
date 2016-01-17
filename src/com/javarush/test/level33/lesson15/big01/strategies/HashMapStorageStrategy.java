package com.javarush.test.level33.lesson15.big01.strategies;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexei on 17.01.2016.
 */
public class HashMapStorageStrategy implements StorageStrategy {

    private HashMap<Long, String> data = new HashMap<>();

    @Override
    public boolean containsKey(Long key) {
        if (key != null) {
            return data.containsKey(key);
        }
        return false;
    }

    @Override
    public boolean containsValue(String value) {
        if (value != null) {
            return data.containsValue(value);
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        if (key != null && value != null)
            data.put(key, value);
    }

    @Override
    public Long getKey(String value) {
        if (value != null && containsValue(value)) {
            for (Map.Entry<Long, String> entry : data.entrySet()){
                if (entry.getValue().equals(value)){
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        if (key != null && containsKey(key)){
            return data.get(key);
        }
        return null;
    }
}
