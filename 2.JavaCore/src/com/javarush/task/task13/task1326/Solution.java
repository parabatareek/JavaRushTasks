package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try (Scanner scanner = new Scanner(System.in);
             BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(scanner.nextLine())))) {

            List<Integer> list = new ArrayList<>();
            while (reader.ready()) {
                list.add(Integer.valueOf(reader.readLine()));
            }
            list.stream().filter(x -> x % 2 == 0).sorted().forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
