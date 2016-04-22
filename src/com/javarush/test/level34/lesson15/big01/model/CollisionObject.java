package com.javarush.test.level34.lesson15.big01.model;


public abstract class CollisionObject extends GameObject {

    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        /*Этот метод должен возвращаться true, если при перемещении текущего
        объекта в направлении direction на FIELD_SELL_SIZE произойдет
        столкновение с объектом gameObject, переданным в качестве параметра.
                Иначе – возвращать false. Столкновением считать совпадение координат x и y.*/
        switch (direction) {
            case LEFT:
                if ((getX() - Model.FIELD_SELL_SIZE) == gameObject.getX() && getY() == gameObject.getY())
                    return true;
                break;
            case RIGHT:
                if ((getX() + Model.FIELD_SELL_SIZE) == gameObject.getX() && getY() == gameObject.getY())
                    return true;
                break;
            case DOWN:
                if ((getY() + Model.FIELD_SELL_SIZE) == gameObject.getY() && getX() == gameObject.getX())
                    return true;
                break;
            case UP:
                if ((getY() - Model.FIELD_SELL_SIZE) == gameObject.getY() && getX() == gameObject.getX())
                    return true;
                break;
        }
        return false;
    }
}
