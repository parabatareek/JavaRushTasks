package com.javarush.task.pro.task04.task0416;

import java.util.Scanner;

/* 
Share a Coke
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);

        int boxes = scanner.hasNextInt() ? scanner.nextInt() : 0, peoples = scanner.hasNextInt() ? scanner.nextInt() : 0;
        double result = (boxes > 0 && peoples > 0) ? 1.0 * boxes / peoples : 0;
        System.out.println(result);
    }
}