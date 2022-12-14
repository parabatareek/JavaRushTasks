package com.javarush.task.pro.task05.task0529;

import java.util.Arrays;

/* 
Галаксианские роботанки (1)
*/

public class Solution {
    public static String robotank = "☖";
    public static String empty = "_";
    public static String hit = "🎯";
    public static int width = 30;
    public static int height = 10;
    public static String[][] field = new String[height][width];

    public static int[][] bombs = new int[height][width];

    public static void main(String[] args) {
        //напишите тут ваш код

        for (String[] row :
                field) {
            Arrays.fill(row, empty);
        }

        for (int[] row :
                bombs) {
            Arrays.fill(row, 0);
        }

        for (int i = 0; i < field.length; i++) {
            int x = (int) (Math.random() * width);
            Arrays.fill(field[i], x, x + 1, robotank);
        }

        boolean bombStatus = true;
        while (bombStatus) {
            for (int i = 0; i < bombs.length; i++) {
                for (int j = 0; j < 10; j++) {
                    while (true) {
                        int x = (int) (Math.random() * width);
                        if (bombs[i][x] != 1) {
                            Arrays.fill(bombs[i], x, x + 1, 1);
                            break;
                        }
                    }
                }
            }

            for (int i = 0; i < bombs.length; i++) {
                for (int j = 0; j < bombs[i].length; j++) {
                    if (bombs[i][j] == 1 && field[i][j].equals(robotank)) field[i][j] = hit;
                }
            }

            int miss = 0;
            for (String[] row :
                    field) {
                for (String value:
                     row) {
                    if (value.equals(robotank)) {
                        miss++;
                        break;
                    }
                }
            }

            bombStatus = miss > 0 ? true : false;
        }

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}
