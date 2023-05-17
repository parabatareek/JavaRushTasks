package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        try (Scanner scanner = new Scanner(System.in);
             FileInputStream inputStream = new FileInputStream(scanner.nextLine())){

            int min = 255;
            while (inputStream.available() > 0)
            {
                int data = inputStream.read();
                min = min < data ? min : data;
            }
            System.out.println(min);
        }
    }
}
