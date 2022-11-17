package com.javarush.task.pro.task08.task0818;

/* 
Путь через аномалию
*/

import java.util.Arrays;

public class Solution {

    public static int[][] anomalySpace = new int[][]{
            {383, 961, 904}, {769, 887, 770}, {184, 608, 406}, {310, 821, 445}, {412, 908, 158},
            {562, 844, 573}, {260, 880, 230}, {635, 254, 756}, {816, 754, 508}, {947, 195, 379},
            {576, 678, 682}, {207, 653, 588}, {901, 315, 223}, {310, 561, 255}, {199, 356, 350},
            {971, 276, 974}, {413, 829, 494}, {344, 345, 322}, {889, 713, 222}, {628, 963, 234},
            {254, 428, 926}, {633, 762, 848}, {896, 130, 653}, {971, 636, 861}, {328, 976, 139}};

    public static double[] safeRoute = new double[25];

    public static void main(String[] args) {
        //напишите тут ваш код
        int index = 0;
        for (int[] array :
                anomalySpace) {
            double sin = Math.sin(array[0]),
                    cos = Math.cos(array[1]),
                    min = Math.min(array[0], Math.min(array[1], array[2])),
                    tn = Math.tan(array[1]),
                    ln = Math.log(array[2]),
                    result = sin * Math.PI + cos * min + tn/ln;

            if (result > 100 && result <= 200) {
                safeRoute[index] = result;
                index++;
            }
//                sin(x) * Pi + cos(y) * min(x, y, z) + tn(y) / ln(z)
        }
        //System.out.println(Arrays.asList(safeRoute));
    }
}
