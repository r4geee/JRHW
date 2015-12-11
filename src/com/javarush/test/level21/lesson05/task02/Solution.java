package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;
        boolean boolFirst;
        boolean boolLast;
        if (this.first != null && n.first != null)
            boolFirst = n.first.equals(this.first);
        else if (this.first == null && n.first == null)
            boolFirst = true;
        else
            boolFirst = false;

        if (this.last != null && n.last != null)
            boolLast = n.last.equals(this.last);
        else if (this.last == null && n.last == null)
            boolLast = true;
        else
            boolLast = false;

        return boolFirst && boolLast;
    }

    public int hashCode() {
        return 31*(first != null ? first.hashCode():0) + (last != null ? last.hashCode():0);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
