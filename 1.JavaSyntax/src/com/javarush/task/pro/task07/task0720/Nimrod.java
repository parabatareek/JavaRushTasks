package com.javarush.task.pro.task07.task0720;

public class Nimrod {
    public static int laser = 100_000,
            rocket = 10_000,
            angelicaKiss;
    public int health = 1_000_000;

    public void defend(int kick){
        health -= applyShield(kick);
    }

    public byte applyShield(int kick){
        return (byte) kick;
    }

    public int attack(){
        return angelicaKiss;
    }
}
