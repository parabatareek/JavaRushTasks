package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        String file1 = new Scanner(System.in).nextLine();
        String file2 = new Scanner(System.in).nextLine();

        readFile(file1, allLines);
        readFile(file2, forRemoveLines);

        List<String> copyAllLines = new ArrayList<>(allLines);

        Solution sol = new Solution();
        try {
            sol.joinData();
        }catch (CorruptedDataException e){
            allLines.addAll(copyAllLines);
        }

    }

    private static void readFile(String file, List<String> list ){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null){
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void joinData() throws CorruptedDataException {
        //List<String> copyAllLines = new ArrayList<>(allLines);

        //List<String> copyforRemoveLines = new ArrayList<>(forRemoveLines);


        if (allLines.containsAll(forRemoveLines)) {
            forRemoveLines.forEach(x -> {
                while (true){
                    int index;
                    if ((index = allLines.indexOf(x)) != -1){
                        allLines.remove(index);
                    }else break;
                }
            });
        }
        else {
            allLines.removeAll(allLines);
            throw new CorruptedDataException();
        }
    }
}
