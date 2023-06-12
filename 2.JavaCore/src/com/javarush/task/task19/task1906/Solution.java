package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) {
        String fileOne = "", fileTwo = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileOne = reader.readLine();
            fileTwo = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        try (FileReader fileReader = new FileReader(fileOne)) {
            while (fileReader.ready()) {
                list.add(fileReader.read());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter fileWriter = new FileWriter(fileTwo)) {
            for (int i = 1; i < list.size(); i = i + 2) {
                fileWriter.write((byte) (int) list.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
