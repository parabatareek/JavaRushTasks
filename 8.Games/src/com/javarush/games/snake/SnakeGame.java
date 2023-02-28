package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    private Snake snake;
    private int turnDelay;
    public static final int WIDTH = 15,
            HEIGHT = 15;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void onTurn(int step) {
        snake.move();
        drawScene();
    }

    private void createGame(){
        snake = new Snake(WIDTH/2, HEIGHT/2);
        turnDelay = 300;
        setTurnTimer(turnDelay);
        drawScene();
    }

    private void drawScene(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellColor(i,j,Color.DARKSEAGREEN);
            }
        }

        snake.draw(this);
    }
}
