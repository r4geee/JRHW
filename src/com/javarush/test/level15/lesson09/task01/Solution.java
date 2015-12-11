package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static
    {
        labels.put(2.0, "bnet");
        labels.put(3.2, "haha");
        labels.put(233.22, "niet");
        labels.put(666.6, "satana");
        labels.put(13.13, "ok");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
