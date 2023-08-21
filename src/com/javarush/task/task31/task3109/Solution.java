package com.javarush.task.task31.task3109;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        File file = new File(fileName);
        Properties properties = new Properties();
        try {
            switch (getFileExtension(fileName)){
                case "xml":
                    properties.loadFromXML(new BufferedInputStream(new FileInputStream(file)));
                    break;
                default:
                    properties.load(new FileReader(file));
            }
        } catch (Exception e){
            return properties;
        }

        return properties;
    }

    private static String getFileExtension(String fileName){
        int dotIndex = fileName.lastIndexOf(".");

        if (dotIndex == -1 || dotIndex == fileName.length() - 1){
            return "";
        }
        return fileName.substring(dotIndex + 1);
    }
}
