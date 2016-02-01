package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.SqlLiteDBStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.StorageStrategy;

/**
 * Created by ame on 01-Feb-16.
 */
public class MyTest {
    public static void main(String[] args) {
        SqlLiteDBStorageStrategy sqlLiteDBStorageStrategy = new SqlLiteDBStorageStrategy();
        Shortener shortener = new Shortener(sqlLiteDBStorageStrategy);
        long newId1 = shortener.getId("lalal");
        //long newId2 = shortener.getId("lalal!!!!!!!!");
        System.out.println(shortener.getString(2L));
        System.out.println(newId1);
        //System.out.println(newId2);

        sqlLiteDBStorageStrategy.CloseConnections();
    }
}
