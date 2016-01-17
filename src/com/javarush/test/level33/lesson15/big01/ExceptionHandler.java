package com.javarush.test.level33.lesson15.big01;


public class ExceptionHandler {
    public static void log(Exception e) {
        Helper.printMessage(e.getMessage());
    }
}
