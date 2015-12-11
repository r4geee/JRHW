package com.javarush.test.level21.lesson08.task02;

import java.util.Arrays;

/* Клонирование
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуйте механизм глубокого клонирования для Tree.
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }
        @Override
        public Tree clone() throws CloneNotSupportedException
        {
            String[] newBranches;
            if (getBranches() != null)
            {
/*                newBranches = new String[getBranches().length];
                for (int i = 0; i < newBranches.length;i++)
                {
                    newBranches[i] = getBranches()[i];
                }*/
                newBranches = Arrays.copyOf(getBranches(), getBranches().length);
            }
            else
                newBranches = null;

            String newName;
            if (getName() != null)
                newName = getName();
            else
                newName = null;

            Tree tree = new Tree(newName, newBranches);

            return tree;
        }
    }


}
