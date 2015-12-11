package com.javarush.test.level22.lesson05.home01;

public class ThisUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else
            if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
                System.out.println(getFormattedStringForSecondThread(t, e, string));
            } else {
                System.out.println(getFormattedStringForOtherThread(t, e, string));
            }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
        return String.format( string, e.getClass().getSimpleName(), e.getCause().toString(), t.getName() );
        //RuntimeException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : 3#

    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
        //java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : TooShortStringSecondThreadException : 2#.
        return String.format( string, e.getCause().toString(), e.getClass().getSimpleName(), t.getName() );
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
        return String.format( string, t.getName(), e.getClass().getSimpleName(), e.getCause().toString() );
        //1# : TooShortStringFirstThreadException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1
    }
}

