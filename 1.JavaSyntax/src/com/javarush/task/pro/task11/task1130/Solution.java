package com.javarush.task.pro.task11.task1130;

/* 
Робозомби космопорта
*/

public class Solution {

    public final String[] lyrics = {"Du...", "Du hast...", "Du hast ultra metal"};

    public static void main(String[] args) {
        Solution solution = new Solution();

        UltraMetal ultraMetal = new UltraMetal();
        ultraMetal.playUltraMetal(solution.lyrics[0], solution.lyrics[1], solution.lyrics[2]);
    }
}