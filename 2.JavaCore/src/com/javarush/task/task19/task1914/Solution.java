package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        String[] result = outputStream.toString().split(" ");

        int first = Integer.parseInt(result[0]), second = Integer.parseInt(result[2]);

        switch (result[1]) {
            case "+":
                result[4] = String.valueOf(first + second);
                break;
            case "-":
                result[4] = String.valueOf(first - second);
                break;
            case "*":
                result[4] = String.valueOf(first * second);
                break;
        }
        System.setOut(consoleOut);

        StringBuilder builder = new StringBuilder();
        for (String s : result) {
            builder.append(s).append(" ");
        }
        System.out.println(builder.toString().trim());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

