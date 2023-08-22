package com.javarush.task.task32.task3213;

import java.io.*;
import java.nio.CharBuffer;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        if (reader != null) {
            byte readerSymbol;

            while ((readerSymbol = (byte) reader.read()) != -1) {
                stringBuilder.append((char)(readerSymbol + key));
            }
        }

        return stringBuilder.toString();
    }
}
