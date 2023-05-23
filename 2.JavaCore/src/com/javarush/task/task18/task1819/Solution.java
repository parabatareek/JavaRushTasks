package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file_1 = new File(scanner.nextLine()),
                file_2 = new File(scanner.nextLine());
        scanner.close();

        try (
                BufferedReader reader1 = new BufferedReader(new FileReader(file_1));
                BufferedWriter writer = new BufferedWriter(new FileWriter(file_1));
                BufferedReader reader2 = new BufferedReader(new FileReader(file_2))) {
            List<String> data = new ArrayList<>();

            while (reader1.ready()){
                data.add(reader1.readLine());
            }
            while (reader2.ready()){
                data.add(reader2.readLine());
            }
            Collections.reverse(data);

            for (String line:
                 data) {
                writer.write(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
