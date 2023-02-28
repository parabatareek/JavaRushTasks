package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake{

    public int x,y;
    public boolean isAlive = true;

    private List<GameObject> snakeParts = new ArrayList<>();

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    private Direction direction = Direction.LEFT;
    private final static String HEAD_SIGN = "\uD83D\uDC7E",
            BODY_SIGN = "\u26AB";

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
        snakeParts.add(new GameObject(x,y));
        snakeParts.add(new GameObject(x+1,y));
        snakeParts.add(new GameObject(x+2,y));
    }

    public void draw(Game game) {
        Color color = isAlive ? Color.BLACK : Color.RED;

        for (int i = 0; i < snakeParts.size(); i++) {
            GameObject part = snakeParts.get(i);

            String sign = (i!=0) ? BODY_SIGN:HEAD_SIGN;

            game.setCellValueEx(part.x, part.y, Color.NONE, sign, color, 75);
        }
    }

    public void move(){

    }
}
