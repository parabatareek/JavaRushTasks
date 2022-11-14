package com.javarush.task.pro.task05.task0510;

/* 
Треугольный массив
*/

import java.util.Arrays;

public class Solution {

    public static int[][] result = new int[10][];

    public static void main(String[] args) {
        //напишите тут ваш код
        int rowCount = 0;
        for (int i = 1; i <= result.length; i++) {
            result[rowCount] = new int[i];
            for (int j = 0; j < result[rowCount].length; j++) {
                result[rowCount][j] = rowCount + j;
            }
            rowCount++;
        }

        for (int[] row:
             result) {
            for (int value:
                 row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
