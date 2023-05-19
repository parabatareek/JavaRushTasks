package com.javarush.task.task18.task1812;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream stream;

    public QuestionFileOutputStream(AmigoOutputStream output) {
        this.stream = output;
    }

    @Override
    public void flush() throws IOException {
        stream.flush();
    }

    @Override
    public void write(int b) throws IOException {
        stream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        stream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        stream.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        if (scanner.nextLine().equals("Д")) stream.close();
    }
}

