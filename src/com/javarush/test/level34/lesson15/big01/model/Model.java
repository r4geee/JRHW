package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;
import java.util.Set;

public class Model {
    public static final int FIELD_SELL_SIZE = 20;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("src/com/javarush/test/level34/lesson15/big01/res/levels.txt"));
    EventListener eventListener;

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel++;
        restart();
    }

    public void move(Direction direction) {
        if (checkWallCollision(gameObjects.getPlayer(), direction)) return;
        if (checkBoxCollision(direction)) return;
        moveByDirection(gameObjects.getPlayer(), direction);
        checkCompletion();

    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        return checkCollisionWithObjects(gameObject, direction, gameObjects.getWalls());
    }

    private boolean checkCollisionWithObjects(CollisionObject checkedGameObject, Direction direction, Set<? extends GameObject> objects) {
        for (GameObject targetGameObject : objects) {
            if (checkedGameObject.isCollision(targetGameObject, direction)) return true;
        }
        return false;
    }

    private Box getCollidedBox(CollisionObject checkedGameObject, Direction direction) {
        for (Box box : gameObjects.getBoxes()) {
            if (checkedGameObject.isCollision(box, direction)) return box;
        }
        return null;
    }

    private void moveByDirection(Movable movable, Direction direction) {
        switch (direction) {
            case LEFT:
                movable.move(-Model.FIELD_SELL_SIZE, 0);
                break;
            case RIGHT:
                movable.move(Model.FIELD_SELL_SIZE, 0);
                break;
            case DOWN:
                movable.move(0, Model.FIELD_SELL_SIZE);
                break;
            case UP:
                movable.move(0, -Model.FIELD_SELL_SIZE);
                break;
        }
    }

    public boolean checkBoxCollision(Direction direction) {
        //передвижение игрока на домик
        if (checkCollisionWithObjects(gameObjects.getPlayer(), direction, gameObjects.getHomes())) return false;
        //передвижение игрока на ящик. если нашли, получили ящик
        Box targetBox = getCollidedBox(gameObjects.getPlayer(), direction);
        //если не нашли, то нету столкновения;
        if (targetBox == null) return false;
        //проверяем полученный ящик
        //сталкивается ли со стенами
        //if (checkCollisionWithObjects(targetBox, direction, gameObjects.getWalls())) return true;
        if (checkWallCollision(targetBox, direction)) return true;
        //сталкивается ли с ящиками
        if (checkCollisionWithObjects(targetBox, direction, gameObjects.getBoxes())) return true;
        moveByDirection(targetBox, direction);
        return false;
    }

    public void checkCompletion() {
        for (Home home : gameObjects.getHomes()) {
            boolean homeHasBox = false;
            for (Box box : gameObjects.getBoxes()) {
                if (home.getX() == box.getX() && home.getY() == box.getY()) {
                    homeHasBox = true;
                    break;
                }
            }
            if (!homeHasBox) return;
        }
        eventListener.levelCompleted(currentLevel);
    }
}
