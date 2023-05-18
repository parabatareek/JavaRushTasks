package com.javarush.task.task18.task1810;

import java.io.*;
import java.util.Scanner;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {
        while (true){
            try (Scanner scanner = new Scanner(System.in);
            FileInputStream inputStream = new FileInputStream(scanner.nextLine())){
                if (inputStream.available() < 1000){
                    throw new DownloadException();
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
