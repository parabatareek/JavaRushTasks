package com.javarush.task.pro.task10.task1025;

/* 
Взлом ретранслятора
*/

public class Solution {

    public static void main(String[] args) {
        //напишите тут ваш код
        Repeater repeater = new Repeater();
        int frequency = repeater.getFrequency();
        String trajectory = repeater.getTrajectory();

        if (frequency < 100) repeater.setFrequency(frequency * 10);
        if (!trajectory.equals("elliptic")) repeater.setTrajectory("elliptic");
    }
}