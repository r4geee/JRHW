package com.javarush.test.level30.lesson02.task01;

import java.util.regex.Pattern;

/* Осваиваем методы класса Integer
Используя метод Integer.parseInt(String, int) реализуйте логику метода convertToDecimalSystem,
который должен переводить переданную строку в десятичное число и возвращать его в виде строки.
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        if (Pattern.compile(("0x\\d*")).matcher(s).matches())
        {
            s = s.substring(2);
            int number = Integer.parseInt(s, 16);
            return Integer.toString(number);
        }
        else if (Pattern.compile(("0[^x^b]\\d*")).matcher(s).matches())
        {
            s = s.substring(1);
            int number = Integer.parseInt(s, 8);
            return Integer.toString(number);
        }
        else if (Pattern.compile(("0b\\d*")).matcher(s).matches())
        {
            s = s.substring(2);
            int number = Integer.parseInt(s, 2);
            return Integer.toString(number);
        }
        else
        {
            int number = Integer.parseInt(s);
            return Integer.toString(number);
        }
    }
}
