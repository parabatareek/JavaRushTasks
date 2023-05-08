package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Создаем объект BufferedReader для чтения данных из стандартного потока ввода
        String url = reader.readLine(); // Считываем URL из стандартного потока ввода
        URL convURL = new URL(url); // Создаем объект URL на основе считанного URL
        String query = convURL.getQuery(); // Получаем строку параметров запроса

        ArrayList<String> parts = new ArrayList<>(); // Создаем список для хранения параметров
        if (query != null) // Если строка параметров не равна null
        {
            String[] params = query.split("&"); // Разбиваем строку параметров на отдельные параметры, используя символ &
            for (String param : params) { // Для каждого параметра
                parts.add(param); // Добавляем его в список параметров
            }
        }

        ArrayList<String> partStr = new ArrayList<>(); // Создаем список для хранения имен параметров
        ArrayList<String> objVal = new ArrayList<>(); // Создаем список для хранения значений параметров с именем "obj"
        String[] tmp; // Создаем массив для хранения временных значений
        for (String part : parts) { // Для каждого параметра
            try {
                tmp = part.split("="); // Разбиваем его на имя и значение, используя символ =
                partStr.add(tmp[0]); // Добавляем имя параметра в список имен параметров
                if (tmp[0].equals("obj"))
                    objVal.add(tmp[1]); // Если имя параметра равно "obj", добавляем его значение в список значений параметров с именем "obj"
            } catch (Exception e) { // Если произошла ошибка
                partStr.add(part); // Добавляем параметр как есть в список имен параметров
            }
        }

        StringBuilder builder = new StringBuilder(); // Создаем объект StringBuilder для формирования строки параметров
        partStr.forEach(val -> { // Для каждого имени параметра
            builder.append(val + " "); // Добавляем его в строку параметров, разделяя пробелом
        });
        System.out.println(builder.toString().trim()); // Выводим строку параметров на экран, убирая лишние пробелы

        objVal.forEach(val -> { // Для каждого значения параметра с именем "obj"
            try {
                alert(Double.parseDouble(val)); // Пытаемся распарсить его как double и вывести на экран, если это число
            } catch (Exception e) {
                alert(val); // Если это не число, выводим как строку
            }
        });
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
