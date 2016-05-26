package com.javarush.test.level34.lesson15.big01.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;


public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        Player player = new Player(Model.FIELD_SELL_SIZE / 2 * 3, Model.FIELD_SELL_SIZE / 2 * 2);

        Home home = new Home(Model.FIELD_SELL_SIZE / 2 * 3, Model.FIELD_SELL_SIZE / 2 * 3);
        Set<Home> homeSet = new HashSet<>();
        homeSet.add(home);

        Box box = new Box(Model.FIELD_SELL_SIZE / 2 * 3, Model.FIELD_SELL_SIZE / 2 * 4);
        Set<Box> boxSet = new HashSet<>();
        boxSet.add(box);

        Wall wall1 = new Wall(Model.FIELD_SELL_SIZE / 2 * 3, Model.FIELD_SELL_SIZE / 2 * 5);
        Wall wall2 = new Wall(Model.FIELD_SELL_SIZE / 2 * 3, Model.FIELD_SELL_SIZE / 2 * 6);
        Set<Wall> wallSet = new HashSet<>();
        wallSet.add(wall1);
        wallSet.add(wall2);

        return new GameObjects(wallSet, boxSet, homeSet, player);
    }
}
