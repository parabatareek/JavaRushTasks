package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake{
    public int x,y;
    private List<GameObject> snakeParts = new ArrayList<>();
    private final static String HEAD_SIGN = "\uD83D\uDC7E",
            BODY_SIGN = "\u26AB";

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
        snakeParts.add(new GameObject(x,y));
        snakeParts.add(new GameObject(x+1,y));
        snakeParts.add(new GameObject(x+2,y));
    }

    public void draw(Game game){
        GameObject gameObject;
        for (int i = 0; i < snakeParts.size(); i++) {
            gameObject = snakeParts.get(i);
            if (i ==0 ) game.setCellValue(gameObject.x, gameObject.y, HEAD_SIGN);
            else game.setCellValue(gameObject.x, gameObject.y, BODY_SIGN);
        }
    }
}
