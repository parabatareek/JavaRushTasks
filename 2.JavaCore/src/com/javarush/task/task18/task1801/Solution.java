package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        FileInputStream stream = new FileInputStream(scanner.next());

        int max = 0;
        while (stream.available() > 0) {
            int data = stream.read();
            max = max > data ? max : data;

            if (stream.available() <= 0) System.out.println(max);
        }
        stream.close();
    }
}
