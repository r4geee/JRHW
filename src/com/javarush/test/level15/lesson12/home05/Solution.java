package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution
{
    private Solution(double d, int i, int y)
    {

    }

    private Solution(String s)
    {

    }

    private Solution (int i)
    {

    }

    protected Solution(String s, String d)
    {

    }

    protected Solution(int s, int d)
    {

    }

    protected Solution(double s, int d)
    {

    }

    Solution (double d, double g)
    {

    }

    Solution (String s, double d)
    {

    }

    Solution (String s, double d, int i)
    {

    }

    public Solution ()
    {

    }

    public Solution (int i, int y, double d)
    {

    }

    public Solution (int i, int y, String s)

    {

    }
}

