package com.javarush.task.task17.task1711;

import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch(args[0]){
            case "-c":
                createPerson(new ArrayList<>(Arrays.asList(args).subList(1, args.length)));
                break;
        }
    }

    private static void createPerson(List<String> params) {
        
    }
}
