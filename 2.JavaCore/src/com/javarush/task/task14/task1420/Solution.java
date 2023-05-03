package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Integer first = 0,
                second = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            first = Integer.valueOf(scanner.next());
            second = Integer.valueOf(scanner.next());
        }

        int more = first > second ? first : second;
        int less = first < second ? first : second;
        while (less != 0) {
            int temp = less;
            less = more % less;
            more = temp;
        }
        System.out.println(more);
    }
}
