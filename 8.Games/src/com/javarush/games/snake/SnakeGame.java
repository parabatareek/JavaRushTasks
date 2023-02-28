package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    private Snake snake;
    private Apple apple;
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
        snake.move(apple);
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.LEFT) {
            snake.setDirection(Direction.LEFT);
        } else if (key == Key.RIGHT) {
            snake.setDirection(Direction.RIGHT);
        } else if (key == Key.UP) {
            snake.setDirection(Direction.UP);
        } else if (key == Key.DOWN) {
            snake.setDirection(Direction.DOWN);
        }
    }

    private void createGame(){
        snake = new Snake(WIDTH/2, HEIGHT/2);
        apple = new Apple(5,5);
        turnDelay = 300;
        setTurnTimer(turnDelay);
        drawScene();
    }

    private void drawScene(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellValueEx(i, j, Color.DARKSEAGREEN, "");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }
}