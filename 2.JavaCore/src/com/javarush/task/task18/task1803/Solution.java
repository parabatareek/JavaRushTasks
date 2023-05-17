package com.javarush.task.task18.task1803;

import java.io.FileInputStream;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/* 
Самые частые байты
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

        Integer maxVal = 0;
        for (Map.Entry<Integer, Integer> entry:
             map.entrySet()) {
            maxVal = maxVal > entry.getValue() ? maxVal : entry.getValue();
        }

        StringBuilder builder = new StringBuilder();
        Integer finalMaxVal = maxVal;
        map.forEach((key, val) -> {
            if (val == finalMaxVal) builder.append(key).append(" ");
        });
        System.out.println(builder.toString().trim());
    }
}
