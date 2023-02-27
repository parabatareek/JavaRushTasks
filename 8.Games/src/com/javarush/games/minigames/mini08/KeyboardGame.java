package com.javarush.games.minigames.mini08;

import com.javarush.engine.cell.*;

/* 
Работа с клавиатурой
*/

public class KeyboardGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(3, 3);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                setCellColor(x, y, Color.WHITE);
            }
        }
    }

    //напишите тут ваш код
    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.UP || key == Key.DOWN || key == Key.LEFT || key == Key.RIGHT) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    setCellColor(i, j, Color.WHITE);
                }
            }
        }
    }

    @Override
    public void onKeyPress(Key key) {
        switch (key) {
            case LEFT:
                onLeftPress();
                break;
            case RIGHT:
                onRightPress();
                break;
            case UP:
                onUpPress();
                break;
            case DOWN:
                onDownPress();
                break;
        }
    }

    private void onDownPress() {
        for (int i = 0; i < 3; i++) {
            setCellColor(i, 2, Color.GREEN);
        }
    }

    private void onUpPress() {
        for (int i = 0; i < 3; i++) {
            setCellColor(i, 0, Color.GREEN);
        }
    }

    private void onRightPress() {
        for (int i = 0; i < 3; i++) {
            setCellColor(2, i, Color.GREEN);
        }
    }

    private void onLeftPress() {
        for (int i = 0; i < 3; i++) {
            setCellColor(0, i, Color.GREEN);
        }
    }
}
