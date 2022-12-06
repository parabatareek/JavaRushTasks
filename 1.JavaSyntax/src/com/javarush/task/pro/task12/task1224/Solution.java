package com.javarush.task.pro.task12.task1224;

/* 
Подключение к системе
*/

import java.util.Arrays;

public class Solution {
    public final static Planet LULG;

    static {
        LULG = new Planet("Лулг");
        LULG.stations = new Planet.OrbitalStation[]{new Planet.OrbitalStation("Большое Орбитальное Кольцо")};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getConnection(LULG)));
    }

    public static int[] getConnection(Planet planet) {
        //напишите тут ваш код
        int[] interfaces = new int[2];
        interfaces[0] = -1;
        interfaces[1] = -1;
        for (int i = 0; i < planet.stations.length; i++) {
            Planet.OrbitalStation station = planet.stations[i];
            for (int j = 0; j < station.controlSystem.getInterfacesNumber(); j++) {
                Boolean connect = station.controlSystem.connect(j);
                if (connect){
                    interfaces[0] = i;
                    interfaces[1] = j;
                }
            }
        }
        if (interfaces[0] == -1 && interfaces[1] == -1) return null;
        else return interfaces;
    }
}
