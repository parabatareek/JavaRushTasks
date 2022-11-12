package com.javarush.task.pro.task04.task0415;

import java.util.Scanner;

/* 
Площадь круга
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
Scanner scanner = new Scanner(System.in);
        int radius, S;
        double pi = 3.14;
        radius = scanner.nextInt();
        S = (int)(pi * radius * radius);
        System.out.println(S);
    }
}