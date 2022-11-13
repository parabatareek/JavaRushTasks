package com.javarush.task.pro.task05.task0504;

/* 
Объединяем массивы
*/

import java.util.Collections;

public class Solution {
    public static int[] firstArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static int[] secondArray = new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
    public static int[] resultArray;

    public static void main(String[] args) {
        //напишите тут ваш код
        resultArray = new int[firstArray.length + secondArray.length];

        int pos = 0;
        for (int element:
             firstArray) {
            resultArray[pos] = element;
            pos++;
        }

        for (int element:
             secondArray) {
            resultArray[pos] = element;
            pos++;
        }

        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + ", ");
        }
    }
}
