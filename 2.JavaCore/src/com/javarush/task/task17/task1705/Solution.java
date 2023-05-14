package com.javarush.task.task17.task1705;

import java.util.ArrayList;
import java.util.List;

/* 
Сад-огород
*/

/**
 * The type Solution.
 */
public class Solution {


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

    }

    /**
     * The type Garden.
     */
    public static class Garden {

        /**
         * The Fruits.
         */
        public final List<String> fruits = new ArrayList<String>();
        public final List<String> vegetables = new ArrayList<String>();

        public synchronized void addFruit(int index, String fruit){
            fruits.add(index, fruit);
        }

        public synchronized void removeFruit(int index){
            fruits.remove(index);
        }

        public synchronized void addVegetable(int index, String vegetable){
            vegetables.add(index, vegetable);
        }

        public synchronized void removeVegetable(int index){
            vegetables.remove(index);
        }
    }
}
