package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileInput = "", fileOutput = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileInput = reader.readLine();
            fileOutput = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String line = "";
        ArrayList<String> data = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\p{L}");

        try (BufferedReader reader = new BufferedReader(new FileReader(fileInput));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput, true))) {
            while ((line = reader.readLine()) != null){
                for (String word:
                     line.split(" ")) {
                    Matcher matcher = pattern.matcher(word);
                    if(!matcher.find()) data.add(word);
                }
            }

            data.forEach(entry -> {
                try {
                    writer.write(entry + " ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
