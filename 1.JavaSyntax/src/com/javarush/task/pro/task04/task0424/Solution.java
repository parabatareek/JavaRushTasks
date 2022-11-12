package com.javarush.task.pro.task04.task0424;

import java.util.Scanner;

/* 
Бомба в ядре планеты
*/

public class Solution {
    public static void main(String[] args) {
        Scanner bombInterface = new Scanner(System.in);

        //напишите тут ваш код
        int num = 0;
        do {
            num = bombInterface.nextInt();
            System.out.println(num);

        } while (num % 10 != 0);
    }
}
