package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Set;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Каждый сгенерированный символ пароля пишите сразу в ByteArrayOutputStream.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution
{
    private static Set <String> set = new HashSet<>();
    public static void main(String[] args)
    {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword()
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        String result;
        do
        {
            bos.reset();
            for (int i = 0; i < 8; i++)
            {
                int random = ((int) (Math.random() * 75) + 48);
                if ((random > 57 && random < 65) || (random > 90 && random < 97))
                {
                    i--;
                    continue;
                }
                bos.write(random);
            }
            result = new String(bos.toByteArray());
        }
        while (!(result.matches("[0-9a-zA-Z]*[0-9]+[0-9a-zA-Z]*") && result.matches("[0-9a-zA-Z]*[a-z]+[0-9a-zA-Z]*") && result.matches("[0-9a-zA-Z]*[A-Z]+[0-9a-zA-Z]*")) && !set.contains(result));
        set.add(result);
        return bos;
    }
}
