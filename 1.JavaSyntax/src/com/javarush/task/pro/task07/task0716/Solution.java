package com.javarush.task.pro.task07.task0716;

/* 
Запуск систем корабля
*/

public class Solution {
    public static char[] chars = {1076, 1086, 1088, 1084, 1080, 1053};

    public static void main(String[] args) {
        //напишите тут ваш код
        for (int i = 0; i < chars.length / 2; i++) {
            char tempt = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = tempt;
        }

        for (char val:
             chars) {
            System.out.print(val);
        }
        System.out.println();
    }
}
