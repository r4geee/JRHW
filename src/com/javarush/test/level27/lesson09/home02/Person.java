package com.javarush.test.level27.lesson09.home02;

public class Person implements Runnable {
    private final Mail mail;

    public Person(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(1000);
            //сделайте что-то тут - do something here
            synchronized (mail)
            {
                //
                mail.setText("Person [" + name + "] has written an email 'AAA'");
                //
                mail.notifyAll();
            }
            //сделайте что-то тут - do something here
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
