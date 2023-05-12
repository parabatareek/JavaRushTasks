package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new InfiniteThread());
        threads.add(new InterruptThread());
        threads.add(new HoorayThread());
        threads.add(new MessageThread());
        threads.add(new ReaderThread());
    }

    public static void main(String[] args) {
    }

    public static class InfiniteThread extends Thread {
        @Override
        public void run() {
            while(true){}
        }
    }

    public static class InterruptThread extends Thread{
        @Override
        public void run() {
              if (Thread.currentThread().isInterrupted())  System.out.println("InterruptedException");
        }
    }

    public static class HoorayThread extends Thread{
        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class MessageThread extends Thread implements Message{

        @Override
        public void run() {
            while (!isInterrupted()) {
            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    public static class ReaderThread extends Thread {
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            while (true) {
                try {
                    String str = reader.readLine();
                    if (str.equals("N"))
                        break;
                    sum += Integer.parseInt(str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(sum);
        }
    }
}