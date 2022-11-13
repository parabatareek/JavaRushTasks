package com.javarush.task.pro.task05.task0524;

/* 
Взлом Кибердракона
*/

import java.util.Scanner;

public class Solution {
    public static int[] coordinates;

    public static void main(String[] args) {
        //напишите тут ваш код
        coordinates = new int[200];
        int count = 0;

        for (int i = 0; i < coordinates.length; i++) {
            if (i % 2 == 0)
                coordinates[i] = count * 10;
            else {
                coordinates[i] = count * 10 + 1;
                count++;
            }
        }
    }
}