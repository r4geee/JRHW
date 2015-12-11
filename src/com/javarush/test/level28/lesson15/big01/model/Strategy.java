package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/**
 * Created by Test on 4/29/2015.
 */
public interface Strategy {
    public List<Vacancy> getVacancies(String searchString);
}
