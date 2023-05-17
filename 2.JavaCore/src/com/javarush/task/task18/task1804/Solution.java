package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        try (Scanner scanner = new Scanner(System.in);
             FileInputStream inputStream = new FileInputStream(scanner.nextLine())) {

            while (inputStream.available() > 0){
                Integer value = inputStream.read();
                if (map.containsKey(value)){
                    map.replace(value, map.get(value), map.get(value)+1);
                }
                else {
                    map.put(value, 1);
                }
            }
        }

        Integer minVal = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry:
                map.entrySet()) {
            minVal = minVal < entry.getValue() ? minVal : entry.getValue();
        }

        StringBuilder builder = new StringBuilder();
        Integer finalMinVal = minVal;
        map.forEach((key, val) -> {
            if (val == finalMinVal) builder.append(key).append(" ");
        });
        System.out.println(builder.toString().trim());
    }
}
