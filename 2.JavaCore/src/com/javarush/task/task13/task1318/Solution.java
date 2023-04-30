package com.javarush.task.task13.task1318;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(sourceFileName);

        Scanner scanner = new Scanner(fileInputStream);
        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine()).append("\n");
        }

        System.out.print(builder.toString());

        scanner.close();
        reader.close();



//        System.out.print("Введите путь к файлу: ");
//        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
//             BufferedReader reader = new BufferedReader(inputStreamReader)) {
//            Path path = Paths.get(reader.readLine());
//            Files.readAllLines(path).stream().forEach(System.out::println);
//        }
    }
}