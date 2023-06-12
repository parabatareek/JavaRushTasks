package com.javarush.task.task18.task1818;

import java.io.*;
import java.util.Scanner;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter writer = new BufferedWriter(new FileWriter(scanner.nextLine(), true));
             BufferedReader reader1 = new BufferedReader(new FileReader(scanner.nextLine()));
             BufferedReader reader2 = new BufferedReader(new FileReader(scanner.nextLine()))
        ) {
            while (reader1.ready()){
                writer.write(reader1.readLine());
            }

            while (reader2.ready()){
                writer.write(reader2.readLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
