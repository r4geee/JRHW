package com.javarush.test.level30.lesson02.home01;

import java.math.BigInteger;

/* Конвертер систем счислений
Реализуйте логику метода convertNumberToOtherNumerationSystem, который должен переводить число number.getDigit()
из одной системы счисления(numerationSystem) в другую (expectedNumerationSystem)
бросьте NumberFormatException, если переданное число некорректно, например, число "120" с системой счисления 2
Валидация для - number.getDigit() - целое не отрицательное
Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumerationSystemType._10, "6");
        //Number number = new Number(NumerationSystemType._2, "1101001000000001100001001110110111111100110010101000100111011011011001001011001100011001100000111101111");
        //Number number = new Number(NumerationSystemType._2, "110100100000000110000100111011011111110011001010101111111111111111111111111");
        Number result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._2);
        System.out.println(result);    //expected 110
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {
/*        int dec = Integer.parseInt(number.getDigit(), number.getNumerationSystem().getNumerationSystemIntValue());
        if (number.getDigit().contains("-") || number.getDigit().contains("."))
        {
            throw new NumberFormatException();
        }
        for (int i = 0; i < number.getDigit().length(); i++){
            int num = number.getDigit().charAt(i) - '0';
            if (num >= number.getNumerationSystem().getNumerationSystemIntValue())
            {
                throw new NumberFormatException();
            }
        }
        return new Number(expectedNumerationSystem, Integer.toString(dec, expectedNumerationSystem.getNumerationSystemIntValue()));*/
/*        long l = Long.parseLong(number.getDigit(), number.getNumerationSystem().getNumerationSystemIntValue());
        BigInteger bigInteger = BigInteger.valueOf(l);
        return new Number(expectedNumerationSystem, bigInteger.toString(expectedNumerationSystem.getNumerationSystemIntValue()));*/
        BigInteger bigInteger = new BigInteger(number.getDigit(), number.getNumerationSystem().getNumerationSystemIntValue());
        if (bigInteger.compareTo(BigInteger.ZERO) < 0)
        {
            throw new NumberFormatException();
        }
        String result = bigInteger.toString(expectedNumerationSystem.getNumerationSystemIntValue());

        return new Number(expectedNumerationSystem, result.toUpperCase());
    }
}
