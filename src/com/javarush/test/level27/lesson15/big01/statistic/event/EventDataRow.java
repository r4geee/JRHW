package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

/**
 * Created by Alexei on 26.07.2015.
 */
public interface EventDataRow {

    public EventType getType();

    public Date getDate();

    public int getTime();
}
