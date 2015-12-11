package com.javarush.test.level24.lesson06.home01;

/*
В работе вам иногда будет нужно закастить класс к какому-нибудь интерфейсу (тут Sayable),
который не реализован в текущем классе
 */
public class Cat implements Pet {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    /**
     * Это - механизм адаптирования к другому интерфейсу - Sayable
     * Внутри метода toSayable создайте class CatPet, реализующий интерфейс Sayable
     * Логика метода say:
     * Если i <= 0, то вывести на экран, что кот спит. Пример, "Васька спит."'
     * Иначе вывести фразу: "имя_кота говорит мяу!". Пример для i=3, "Васька говорит мяяяу!"
     * <p/>
     * <b>Пример вывода:</b>
     * Мурзик спит.
     * Васька говорит мяяу!
     * Кошка говорит мяяяяяу!
     * Мыша пищит.
     * Томас говорит мяу!
     * <p/>
     * @param i количество букв 'я' в слове мяу
     * @return экземпляр класса CatPet
     */
    public Sayable toSayable(final int i) {
        class CatPet extends Cat implements Sayable
        {
            CatPet(String name)
            {
                super(name);
            }
            @Override
            public String say()
            {
                final int ya = i;
                String result = "";
                if (ya <= 0)
                {
                    result = name + " спит.";
                }
                else
                {
                    StringBuilder tempSb = new StringBuilder();
                    tempSb.append(name).append(" говорит м");
                    for (int y = 0; y < ya; y++)
                    {
                        tempSb.append("я");
                    }
                    tempSb.append("у!");
                    result = tempSb.toString();
                }
                return result;
            }
        }
        return new CatPet(name);
    }
}