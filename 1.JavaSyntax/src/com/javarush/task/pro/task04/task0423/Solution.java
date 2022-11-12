package com.javarush.task.pro.task04.task0423;

import java.util.Scanner;

/* 
Калибровка климата
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        //напишите тут ваш код
        for (int i = 0; i < 5; i++) {
            if (scanner.hasNextInt()){
                sum += scanner.nextInt();
            }
        }
        System.out.println(sum / 5);
    }
}
