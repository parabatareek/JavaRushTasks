package com.javarush.task.pro.task05.task0511;

import java.util.Scanner;

/* 
Создаем двумерный массив
*/

public class Solution {
    public static int[][] multiArray;

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int rowNum = scanner.nextInt();
        multiArray = new int[rowNum][];

        for (int i = 0; i < rowNum; i++) {
            int columnCount = scanner.nextInt();
            multiArray[i] = new int[columnCount];
        }
    }
}
