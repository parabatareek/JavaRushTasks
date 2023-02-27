package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";

    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField,
            countFlags,
            countClosedTiles = SIDE * SIDE;
    private boolean isGameStopped;


    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    public void onMouseLeftClick(int x, int y) {
        openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    private void createGame() {
        isGameStopped = false;
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
            }
        }
        countFlags = countMinesOnField;
        countMineNeighbors();
    }

    private void countMineNeighbors() {
        for (GameObject[] objects :
                gameField) {
            for (GameObject object :
                    objects) {
                if (!object.isMine) {
                    for (GameObject neighbor :
                            getNeighbors(object)) {
                        if (neighbor.isMine) object.countMineNeighbors++;
                    }
                }
            }
        }
    }

    private void openTile(int x, int y) {
        GameObject gameObject = gameField[y][x];

        if (gameObject.isOpen || gameObject.isFlag || isGameStopped) return;

        countClosedTiles--;
        gameObject.isOpen = true;
        setCellColor(x, y, Color.GREEN);
        if (gameObject.isMine) {
            setCellValueEx(gameObject.x, gameObject.y, Color.RED, MINE);
            gameOver();
        } else if (gameObject.countMineNeighbors == 0) {
            setCellValue(gameObject.x, gameObject.y, "");
            for (GameObject object :
                    getNeighbors(gameObject)) {
                if (!object.isOpen) openTile(object.x, object.y);
            }
        } else {
            setCellNumber(x, y, gameObject.countMineNeighbors);
        }

        if (!gameObject.isMine && countClosedTiles == countMinesOnField) win();
    }

    private void markTile(int x, int y) {
        GameObject gameObject = gameField[y][x];

        if (isGameStopped || gameObject.isOpen || (countFlags == 0 && !gameObject.isFlag)) {
            return;
        }

        if (gameObject.isFlag) {
            countFlags++;
            gameObject.isFlag = false;
            setCellValue(x, y, "");
            setCellColor(x, y, Color.ORANGE);
        } else {
            countFlags--;
            gameObject.isFlag = true;
            setCellValue(x, y, FLAG);
            setCellColor(x, y, Color.YELLOW);
        }
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "Game Over", Color.RED, 20);
    }

    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "YOU WIN", Color.BLUE, 20);
    }
}