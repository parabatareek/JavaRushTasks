package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        List<FileData> fileList =  new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)){
            String line;

            while (!(line  = scanner.nextLine()).equals("break")){
                FileData fileData = new FileData(line);
                fileList.add(Integer.parseInt(fileData.orderNum), fileData);
            }

            Collections.sort(fileList, Comparator.comparingInt(fileList::indexOf));
        }

        for (FileData file:
             fileList) {
            try (BufferedWriter writer = new BufferedWriter(new FileOutputStream(file.))){

            }
        }
    }

    static class FileData{
        String name, extension, part, orderNum, fileName;

        public FileData(String fileName) {
            String[] fileData =  fileName.split(".");
            this.name = fileData[0];
            this.extension = fileData[1];
            this.part = fileData[2];
            this.orderNum = fileData[2].split("part")[1];
            this.fileName  = fileName;
        }
    }
}
