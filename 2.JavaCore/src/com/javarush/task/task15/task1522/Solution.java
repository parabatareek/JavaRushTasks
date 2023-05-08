package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }
    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        readKeyFromConsoleAndInitPlanet();
    }


    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        try (Scanner scanner = new Scanner(System.in)){
            String input = scanner.nextLine();
            if (input.equals(Planet.SUN)) thePlanet = Sun.getInstance();
            else if (input.equals(Planet.MOON)) thePlanet = Moon.getInstance();
            else if (input.equals(Planet.EARTH)) thePlanet = Earth.getInstance();
            else thePlanet = null;
        }
    }
}
