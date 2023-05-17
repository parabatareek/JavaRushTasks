package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

/**
 * The type Solution.
 */
public class Solution {
    /**
     * The constant allPeople.
     */
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        //напишите тут ваш код
        switch (args[0]) {
            case "-c":
                createPeople(Arrays.asList(args));
                break;
            case "-r":
                readPeople(Integer.parseInt(args[1]));
                break;
            case "-u":
                updatePeople(Arrays.asList(args));
                break;
            case "-d":
                deletePeople(Integer.parseInt(args[1]));
                break;
        }
    }


    private static void createPeople(List<String> args) {
        Person person;
        switch (args.get(2)) {
            case "м":
                allPeople.add(Person.createMale(args.get(1), getBD(args.get(3))));
                break;
            case "ж":
                allPeople.add(Person.createFemale(args.get(1), getBD(args.get(3))));
                break;
        }
        System.out.println(allPeople.size() - 1);
    }

    private static void readPeople(int index) {
        Person person = allPeople.get(index);
        StringBuilder builder = new StringBuilder();

        builder.append(person.getName() + " "
                + getSex(person.getSex()) + " "
                + new SimpleDateFormat("dd-MMM-yyyy").format(person.getBirthDate()));
        System.out.println(builder);
    }

    private static void updatePeople(List<String> args) {
        Person person = allPeople.get(Integer.parseInt(args.get(1)));
        person.setName(args.get(2));
        person.setSex(getSex(args.get(3)));
        person.setBirthDate(getBD(args.get(4)));
    }

    private static void deletePeople(int index) {
        Person person = allPeople.get(index);
        person.setName(null);
        person.setSex(null);
        person.setBirthDate(null);
    }

    private static Date getBD(String birthday) {
        Date bd = new Date();
        try {
            bd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return bd;
    }

    private static Sex getSex(String sex) {
        return sex.equals("м") ? Sex.MALE : Sex.FEMALE;
    }

    private static String getSex(Sex sex) {
        return sex.equals(Sex.MALE) ? "м" : "ж";
    }
}
