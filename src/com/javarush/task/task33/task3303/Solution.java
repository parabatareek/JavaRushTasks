package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

/* 
Десериализация JSON объекта
*/

public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try {
         File file = new File(fileName);
         return  mapper.readValue(file, clazz);
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
