package com.javarush.games.snake;

import java.util.ArrayList;
import java.util.List;

public class Snake{
    public int x,y;
    private List<GameObject> snakeParts = new ArrayList<>();

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
        snakeParts.add(new GameObject(x,y));
        snakeParts.add(new GameObject(x+1,y));
        snakeParts.add(new GameObject(x+2,y));
    }
}
