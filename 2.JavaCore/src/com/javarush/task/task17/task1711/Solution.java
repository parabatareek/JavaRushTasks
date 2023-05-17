package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    createPerson(Arrays.asList(Arrays.copyOfRange(args, 1, args.length)));
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    updatePerson(Arrays.asList(Arrays.copyOfRange(args, 1, args.length)));
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    deletePeople(Arrays.asList(Arrays.copyOfRange(args, 1, args.length)));
                }
                break;
            case "-i":
                synchronized (allPeople){
                    infoPeople(Arrays.asList(Arrays.copyOfRange(args, 1, args.length)));
                }
                break;
        }
    }

    private static void infoPeople(List<String> params) {
        params.forEach(x -> {
            Person person = allPeople.get(Integer.parseInt(x));
            StringBuilder builder = new StringBuilder();
            builder.append(person.getName())
                    .append(" ")
                    .append(getSex(person.getSex()))
                    .append(" ")
                    .append(new SimpleDateFormat("dd-MMM-yyyy").format(person.getBirthDate()));
            System.out.println(builder);
        });
    }

    private static void deletePeople(List<String> params) {
        params.forEach(x -> {
            Person person = allPeople.get(Integer.parseInt(x));
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
        });
    }

    private static void updatePerson(List<String> params) {
        for (int i = 0; i < params.size(); i += 4) {
            List<String> subParams = params.subList(i, i + 4);
            Person person = allPeople.get(Integer.parseInt(subParams.get(0)));

            person.setName(subParams.get(1));
            person.setSex(getSex(subParams.get(2)));
            try {
                person.setBirthDate(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(subParams.get(3)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createPerson(List<String> params) {
        for (int i = 0; i < params.size(); i += 3) {
            Person person;
            List<String> subParams = params.subList(i, i + 3);

            Date birthDate = new Date();
            try {
                birthDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(subParams.get(2));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (subParams.get(1).equals("м")) person = Person.createMale(subParams.get(0), birthDate);
            else person = Person.createFemale(subParams.get(0), birthDate);

            allPeople.add(person);
            System.out.println(allPeople.size() - 1);
        }
    }

    private static Sex getSex(String sex) {
        return sex.equals("м") ? Sex.MALE : Sex.FEMALE;
    }

    private static String getSex(Sex sex) {
        return sex.equals(Sex.MALE) ? "м" : "ж";
    }
}
