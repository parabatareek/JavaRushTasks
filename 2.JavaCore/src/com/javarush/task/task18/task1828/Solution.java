package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.*;


/* 
Прайсы 2
*/

public class Solution {
    private static HashMap<Integer, Product> products = new HashMap<>();
    private static File dataFile;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        dataFile = new File(scanner.nextLine());

        dataInit();

        switch (args[0]) {
            case "-u":
                update(new Product(Integer.valueOf(args[1]),
                        args[4],
                        args[2],
                        args[3]));
                break;
            case "-d":
                delete(Integer.valueOf(args[0]));
                break;
        }
    }

    private static void dataInit() {
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))){
            while (reader.ready()){
                Product product = new Product(reader.readLine());
                products.put(product.id, product);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void delete(Integer id) {
    }

    private static void update(Product product) {
        products.
    }

    private static class Product {
        private int id;
        private String productName, price, quantity;

        public Product(int id, String quantity, String productName, String price) {
            this.id = id;
            this.quantity = quantity;
            this.productName = productName;
            this.price = price;
        }

        public Product(String data) {
            this.id = Integer.parseInt(data.substring(0,8).trim());
            this.productName = data.substring(8, 38).trim();
            this.price = data.substring(38, 46).trim();
            this.quantity = data.substring(46, 50).trim();
        }

        @Override
        public String toString() {
            return String.format("%-8d%-30s%-8s%-4s", id, productName, price, quantity);
        }
    }
}
