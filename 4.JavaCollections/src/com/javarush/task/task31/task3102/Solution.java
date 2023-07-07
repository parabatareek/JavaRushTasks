package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        //File rootDir = new File(root);

        List<String> files = new ArrayList<>();

        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(Paths.get(root), options, 50, new GetFiles(files));

        return files;
    }

    public static void main(String[] args) throws IOException {
        List<String> files = getFileTree(args[0]);
    }

    private static class GetFiles extends SimpleFileVisitor<Path>{
        private List<String> result;

        public GetFiles(List<String> result) {
            this.result = result;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
            String s = path.toAbsolutePath().toString();

            result.add(s);
            return FileVisitResult.CONTINUE;
        }
    }
}
