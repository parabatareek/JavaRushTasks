package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable {
    public static void main(String[] args){
        File externalFile = new File("../task2014/externalizable.txt");
        Solution savedObject = new Solution(38);

        try (FileOutputStream fileOutputStream = new FileOutputStream(externalFile);
             FileInputStream fileInputStream = new FileInputStream(externalFile);
             ObjectInput input = new ObjectInputStream(fileInputStream);
             ObjectOutput output = new ObjectOutputStream(fileOutputStream)){

            output.writeObject(savedObject);

            Solution loadedObject = new Solution(100500);
            loadedObject = (Solution) input.readObject();

            if (savedObject.equals(loadedObject)) System.out.println(new Solution(4));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
