package com.javarush.task.pro.task08.task0819;

import java.util.Random;

/* 
Амиголятор и Био-диего
*/

import static com.javarush.task.pro.task08.task0819.CosmicAnomaly.*;

public class Solution {

    public static void main(String[] args) {
        Random random = new Random();
        int rand = 0, returnNum;
        //напишите тут ваш код
        while (true){
            rand = random.nextInt(upperBound - lowerBound) + lowerBound;
            returnNum = nextAttempt(rand);

            if (rand == returnNum) break;
        }
    }
}
