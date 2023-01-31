package com.javarush.task.pro.task16.task1616;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TreeSet;

/* 
Тренировка временных зон
*/

public class Solution {

    public static void main(String[] args) {
        TreeSet<String> sortedZones = getSortedZones();
        System.out.println(sortedZones.size());
        System.out.println(sortedZones.first());
        System.out.println(sortedZones.last());

        System.out.println(getBeijingDateTime());
    }

    static TreeSet<String> getSortedZones() {
        //напишите тут ваш код
        var zones = new TreeSet<String>();
        for (String zone:
             ZoneId.getAvailableZoneIds()) {
            zones.add(zone);
        }
        return zones;
    }

    static ZonedDateTime getBeijingDateTime() {
        //напишите тут ваш код

        return  ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Asia/Shanghai")) ;
    }
}
