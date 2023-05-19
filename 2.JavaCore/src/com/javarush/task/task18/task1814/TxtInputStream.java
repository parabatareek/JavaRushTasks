package com.javarush.task.task18.task1814;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);

        if (!isTxt(fileName)){
            super.close();
            throw new UnsupportedFileNameException();
        }
    }

    private boolean isTxt(String fileName){
        int lastDotIndex = fileName.lastIndexOf(".");

        String extension = fileName.substring(lastDotIndex + 1);
        return extension.equals("txt") ? true : false;
    }

    public static void main(String[] args) {
    }
}

