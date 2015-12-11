package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/
import java.util.*;

public class Beach implements Comparable<Beach>
{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized  String getName() {
        return name;
    }

    public synchronized  void setName(String name) {
        this.name = name;
    }

    public synchronized  float getDistance() {
        return distance;
    }

    public synchronized  void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized  int getQuality() {
        return quality;
    }

    public synchronized  void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach o)
    {
        return getName().compareTo(o.getName()) + Float.compare(getDistance(), o.getDistance()) * 2 + Integer.compare(getQuality(), o.getQuality()) * 10000;
    }


    public static void main(String[] args)
    {
        Beach beach1=new Beach("Stroomi",20,3);
        Beach beach2=new Beach("Kakumae",19,2);
        Beach beach3=new Beach("Pirita",19,3);
        Beach beach4=new Beach("Karjer",20,3);
        Beach beach5=new Beach("Harku",20,5);
        List<Beach> list = new ArrayList<Beach>();
        list.add(beach1);
        list.add(beach2);
        list.add(beach3);
        list.add(beach4);
        list.add(beach5);
        for ( Beach beach : list)
            System.out.println(beach.getName() + " " + beach.getDistance() + " " + beach.getQuality());
        Collections.sort(list);
        System.out.println();
        System.out.println("--------------");
        System.out.println();
        for ( Beach beach : list)
            System.out.println(beach.getName() + " " + beach.getDistance() + " " + beach.getQuality());
    }
}
