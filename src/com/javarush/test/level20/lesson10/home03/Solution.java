package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите и исправьте ошибку.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
*/
public class Solution implements Serializable
{
    public static final long serialVersionUID = 2L;
    public static class A {
        protected String name = "A";

        public A()
        {
            super();
        }
        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public static final long serialVersionUID = 1L;
        public B(String name) {
            super(name);
            this.name += name;
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        B b = new Solution().new B("bshechka");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutput objectOutput = new ObjectOutputStream(baos);
        objectOutput.writeObject(b);
        baos.flush();
        baos.close();
        objectOutput.flush();
        objectOutput.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInput objectInput = new ObjectInputStream(bais);
        B b2 = (B) objectInput.readObject();
        System.out.println(b2.name);
    }
}
