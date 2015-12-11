package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome
{
    private ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void setHorses(ArrayList<Horse> horses)
    {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();
        Horse horse1=new Horse("Gonzalez",3,0);
        Horse horse2=new Horse("Speedi",3,0);
        Horse horse3=new Horse("Bucefal",3,0);
        ArrayList<Horse> h=new ArrayList<Horse>();
        h.add(horse1);
        h.add(horse2);
        h.add(horse3);
        game.setHorses(h);
        game.run();
        game.printWinner();
    }

    public void run() throws InterruptedException
    {
        for(int i = 0; i < 100; i++)
        {
            move();
            print();
            Thread.sleep(500);
        }
    }

    public void move()
    {
        for (Horse horse : getHorses())
        {
            horse.move();
        }
    }

    public void print()
    {
        for (Horse horse : getHorses())
        {
            horse.print();
        }

        System.out.println();
        System.out.println();
    }

    public Horse getWinner()
    {
        int max = Integer.MIN_VALUE;
        Horse winner = null;
        for (Horse horse : getHorses())
        {
            if(horse.getSpeed() > max)
                winner = horse;
        }
        return winner;
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}

