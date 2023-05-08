package com.javarush.task.task16.task1604;

/* 
Вывод стек-трейса
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        // Создаем новый поток с экземпляром класса SpecialThread в качестве цели
        Thread thread = new Thread(new SpecialThread());
        // Запускаем новый поток
        thread.start();

        System.out.println("*****************");

        // Получаем stacktrace текущего потока и выводим каждый элемент в консоль
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            System.out.println(element);
        }
    }

    // Класс, реализующий интерфейс Runnable
    public static class SpecialThread implements Runnable{
        @Override
        public void run() {
            // Получаем stacktrace текущего потока и выводим каждый элемент в консоль
            for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
                System.out.println(element);
            }
        }
    }
}
