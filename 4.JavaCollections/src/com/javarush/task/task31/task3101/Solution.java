package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.Map;
import java.util.TreeMap;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) {
        File path = new File(args[0]),
                file = new File(args[1]);

        if (FileUtils.isExist(file)) {
            FileUtils.renameFile(file, new File(file.getAbsolutePath() + "allFilesContent.txt"));
        }

        for (File folderFile:
             path.listFiles()) {
            if (folderFile.isFile()) copyData(folderFile,  file);
        }

    }

    private static void copyData(File folderFile, File file) {
        try (FileReader reader  = new FileReader(file)){

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
