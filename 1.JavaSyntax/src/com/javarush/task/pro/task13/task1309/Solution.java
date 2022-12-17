package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        //напишите тут ваш код
        grades.put("Markov", 3.);
        grades.put("Kubkin", 4.);
        grades.put("Markova", 5.);
        grades.put("Getman", 6.);
        grades.put("Scott", 7.);
    }
}
