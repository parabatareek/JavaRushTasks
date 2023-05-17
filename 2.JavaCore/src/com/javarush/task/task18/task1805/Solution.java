package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Set<Integer> set = new HashSet<>();

        try (Scanner scanner = new Scanner(System.in);
            FileInputStream inputStream = new FileInputStream(scanner.nextLine())){
            while (inputStream.available() > 0){
                set.add(inputStream.read());
            }
        }
        StringBuilder builder = new StringBuilder();
        set.stream().sorted().forEach(x -> builder.append(x).append(" "));
        System.out.println(builder.toString().trim());
    }
}
