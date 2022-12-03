package com.javarush.task.pro.task09.task0922;

/* 
Закосить под пиратов
*/

import java.util.Arrays;
import java.util.Collections;

public class PiratesWorkbench {

    public static String[] piratesDB = new String[]{
            "Drax",
            "Yondu Udonta",
            "Maz Kanata",
            "キャプテン・ハーロック",
            "Star-Lord",
            "Christopher Summers",
            "Крысс",
            "Весельчак У",
            "Nebula",
            "Rocket",
            "Han Solo",
            "boba Fett"
    };

    public static void main(String[] args) {
        System.out.println(Arrays.toString(piratesDB));

        corruptDB();
        addTwoNames();

        System.out.println(Arrays.toString(piratesDB));
    }

    public static void corruptDB() {
        //напишите тут ваш код
        int counter = 0;
        for (int i = 0; i < piratesDB.length && counter < 2; i++) {
            if (piratesDB[i].contains("b")){
                piratesDB[i] = piratesDB[i].replaceAll("b", "\b");
                counter++;
            }
        }
    }

    public static void addTwoNames() {
        //напишите тут ваш код
        int lenght = piratesDB.length;
        String[] newDB = new String[lenght + 2];
        System.arraycopy(piratesDB, 0, newDB, 0, lenght);
        newDB[lenght] = "Рыжий Амиго";
        newDB[lenght + 1] = "Одноглазый Диего";
        piratesDB = newDB;
    }
}
