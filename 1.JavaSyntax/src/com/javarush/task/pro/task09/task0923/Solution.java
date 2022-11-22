package com.javarush.task.pro.task09.task0923;

/* 
Ранг доступа — Пиратский Капитан
*/

import static com.javarush.task.pro.task09.task0923.CaptainBridge.checkAccess;
import static com.javarush.task.pro.task09.task0923.CaptainBridge.debugAccess;

public class Solution {
    public static void main(String[] args) {
        String[] roles = new String[]{"Раб", "Гость", "Боец", "Ветеран", "Картографист", "Капитан", "Стив"};
        String trueRole = "";
        for (String role :
                roles) {
            if (debugAccess(role)) trueRole = role;
        }
        checkAccess(trueRole);
    }
}
