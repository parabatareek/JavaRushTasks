package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH = 15,
            HEIGHT = 15;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame(){
        drawScene();
        new Apple(7,7).draw(this);
    }

    private void drawScene(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellColor(i,j,Color.DARKSEAGREEN);
            }
        }
    }
}
