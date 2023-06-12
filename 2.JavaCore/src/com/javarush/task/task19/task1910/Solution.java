package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) {
        String fileInput, fileOutput = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileInput = reader.readLine();
            fileOutput = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileInput));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput, true))) {
            while ((line = reader.readLine()) != null){
                writer.write(line.replaceAll("\\p{P}", ""));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
