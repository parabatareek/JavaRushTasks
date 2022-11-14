package com.javarush.task.pro.task05.task0526;

/* 
Атака вирусов
*/

import java.util.Arrays;

public class Solution {
    public static int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

    public static void main(String[] args) {
        printArray();

        //напишите тут ваш код

        int[][] mirrowArray = new int[array.length][array[0].length];

        int rowCount = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            mirrowArray[rowCount] = array[i];
            rowCount++;
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = mirrowArray[i];
        }

        printArray();
    }

    public static void printArray() {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
