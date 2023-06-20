package com.javarush.task.task19.task1926;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader fileName  = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new FileReader(fileName.readLine()))){
            String line;

            while ((line = reader.readLine()) != null){
                System.out.println(new StringBuffer(line).reverse());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
