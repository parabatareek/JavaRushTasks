package com.javarush.task.pro.task05.task0523;

/* 
Охота на Кибердракона
*/

public class Solution {
    public static int[] coordinates = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) {
        //напишите тут ваш код
        int y = 0, x = 0;
        for (int value:
             coordinates) {
            y += value % 2 == 0 ? value :0;
            x += value %2 != 0 ? value : 0;
        }
        System.out.println("("+x+";"+y+")" );
    }
}
