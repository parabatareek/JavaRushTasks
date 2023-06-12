package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws FileNotFoundException {
        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            fileName = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);


        System.setOut(stream);

        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);

        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName))){
            bufferedOutputStream.write(result.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println(result);
    }



    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

