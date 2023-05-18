package com.javarush.task.task18.task1807;

import java.io.*;
import java.util.Scanner;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        int count = 0;
        try (Scanner scanner = new Scanner(System.in);
            FileInputStream inputStream = new FileInputStream(scanner.nextLine())){
            if (inputStream.available() > 0){
                byte[] buffer = new byte[inputStream.available()];
                inputStream.read(buffer);

                for (int i = 0; i < buffer.length; i++) {
                    if (buffer[i] == 44) count++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(count);
    }
}
