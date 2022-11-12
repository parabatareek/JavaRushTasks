package com.javarush.task.pro.task04.task0410;

import java.util.Scanner;

/* 
Второе минимальное число из введенных
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
    Scanner scanner = new Scanner(System.in);
    int input, first_min = Integer.MAX_VALUE, second_min = Integer.MAX_VALUE;

    while (true){
        if (scanner.hasNextInt()){
            input = scanner.nextInt();
            if (input < first_min) {
                second_min = first_min;
                first_min = input;
            }
            if (input > first_min && input < second_min) second_min = input;
        }
        else break;
    }
        if (second_min != Integer.MAX_VALUE) System.out.println(second_min);

    }
}