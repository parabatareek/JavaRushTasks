package com.javarush.task.task13.task1319;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {

        // Создаем два объекта типа Scanner для считывания ввода пользователя
        // Объект scanner используется для считывания названия файла
        // Объект scanner1 используется для считывания строк, которые будут записываться в файл
        try (Scanner scanner = new Scanner(System.in);
             Scanner scanner1 = new Scanner(System.in);

             // Создаем объект BufferedWriter для записи данных в файл
             // Объект FileWriter используется для создания файла и указания его имени
             BufferedWriter writer = new BufferedWriter(new FileWriter(Paths.get(scanner.nextLine()).toFile()))) {

            // Создаем StringBuilder для хранения всех считанных строк
            StringBuilder builder = new StringBuilder();

            // Цикл для считывания строк с консоли
            while (scanner1.hasNextLine()) {
                String value = scanner1.nextLine();

                // Добавляем строку в StringBuilder и добавляем символ переноса строки
                builder.append(value).append("\n");

                // Если пользователь ввел "exit", то завершаем цикл
                // и записываем все считанные строки в файл
                if (value.equals("exit")) {
                    writer.write(builder.toString());
                    break;
                }
            }

        } catch (IOException e) {
            // Если произошла ошибка ввода-вывода, то выводим сообщение об ошибке
            System.out.println(e);
        }
    }
}
