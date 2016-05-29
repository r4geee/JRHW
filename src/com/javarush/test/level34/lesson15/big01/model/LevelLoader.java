package com.javarush.test.level34.lesson15.big01.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        while (level > 60)
            level = level - 60;
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(levels.toFile()))) {
            String newLine;
            boolean doAdd = false;

            while ((newLine = bufferedReader.readLine()) != null) {
                if (newLine.equals(String.format("Maze: %d", level)))
                    doAdd = true;
                else if (newLine.equals("*************************************") && doAdd) {
                    break;
                }
                if (doAdd)
                    lines.add(newLine);
            }
        }
        catch (IOException e1) {

        }
        int xSize = Integer.valueOf(lines.get(2).substring(8));
        int ySize = Integer.valueOf(lines.get(3).substring(8));
        char[][] chars = new char[ySize][xSize];

        for (int i = 0; i < lines.size() - 8; i++) {
            chars[i] = lines.get(i + 7).toCharArray();
        }


        Set<Home> homeSet = new HashSet<>();
        Set<Box> boxSet = new HashSet<>();
        Set<Wall> wallSet = new HashSet<>();
        Player player = null;
        for (int j = 0; j < chars.length; j++) {
            for (int i = 0; i < chars[j].length; i++) {
                int x = Model.FIELD_SELL_SIZE / 2 + Model.FIELD_SELL_SIZE * i;
                int y = Model.FIELD_SELL_SIZE / 2 + Model.FIELD_SELL_SIZE * j;
                switch (chars[j][i]) {
                    case 'X':
                        wallSet.add(new Wall(x, y));
                        break;
                    case '*':
                        boxSet.add(new Box(x, y));
                        break;
                    case '.':
                        homeSet.add(new Home(x, y));
                        break;
                    case '&':
                        homeSet.add(new Home(x, y));
                        boxSet.add(new Box(x, y));
                        break;
                    case '@':
                        player = new Player(x, y);
                        break;

                }
            }
        }
        //////////////////////
//        Player player = new Player(Model.FIELD_SELL_SIZE / 2 * 3, Model.FIELD_SELL_SIZE / 2 * 2);
//
//        Home home = new Home(Model.FIELD_SELL_SIZE / 2 * 3, Model.FIELD_SELL_SIZE / 2 * 3);
//
//        homeSet.add(home);
//
//        Box box = new Box(Model.FIELD_SELL_SIZE / 2 * 3, Model.FIELD_SELL_SIZE / 2 * 4);
//        boxSet.add(box);
//
//        Wall wall1 = new Wall(Model.FIELD_SELL_SIZE / 2 * 3, Model.FIELD_SELL_SIZE / 2 * 5);
//        Wall wall2 = new Wall(Model.FIELD_SELL_SIZE / 2 * 3, Model.FIELD_SELL_SIZE / 2 * 6);
//
//        wallSet.add(wall1);
//        wallSet.add(wall2);

        return new GameObjects(wallSet, boxSet, homeSet, player);
    }
}
