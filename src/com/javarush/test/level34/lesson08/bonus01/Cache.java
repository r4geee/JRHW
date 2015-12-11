package com.javarush.test.level34.lesson08.bonus01;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        V value = cache.get(key);
        if (value != null) {
            return value;
        }
        else {
            Constructor<V> constructor = clazz.getConstructor(key.getClass());
            V newInstance = constructor.newInstance(key);
            cache.put(key, newInstance);
            return newInstance;
        }
    }

    public boolean put(V obj) {
        //TODO add your code here
        try {
            Method method = obj.getClass().getMethod("getKey", null);
            method.setAccessible(true);
            K key = (K) method.invoke(obj, null);
            cache.put(key, obj);
            return true;
        }
        catch (NoSuchMethodException ignored) {

        }
        catch (InvocationTargetException e) {

        }
        catch (IllegalAccessException e) {

        }
        return false;
    }

    public int size() {
        return cache.size();
    }
}
