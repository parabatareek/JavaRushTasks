package com.javarush.task.task22.task2213;

public class Tetris {
    private Field field;
    private Figure figure;
    static Tetris game;

    public static void main(String[] args) {
        game = new Tetris();
        game.run();
    }

    public Field getField(){
        return field;
    }

    public Figure getFigure(){
        return figure;
    }

    void step(){}

    void run() {}
}
