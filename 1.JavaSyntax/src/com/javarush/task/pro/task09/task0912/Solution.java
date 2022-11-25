package com.javarush.task.pro.task09.task0912;

/* 
Проверка URL-адреса
*/

public class Solution {
    public static void main(String[] args) {
        String[] urls = {"https://javarush.ru", "https://google.com", "http://wikipedia.org", "facebook.com", "https://instagram", "codegym.cc"};
        for (String url : urls) {
            String protocol = checkProtocol(url);
            String domain = checkDomain(url);

            System.out.println("У URL-адреса - " + url + ", сетевой протокол - " + protocol + ", домен - " + domain);
        }
    }

    public static String checkProtocol(String url) {
        //напишите тут ваш код
        String protocol = url.startsWith("https") ? "https" : url.startsWith("http") ? "http" : "неизвестный";
        return protocol;
    }

    public static String checkDomain(String url) {
        //напишите тут ваш код
        String[] domains = new String[] {"com", "net", "org","ru"};

        for (String domain:
             domains) {
            if (url.endsWith(domain)) return domain;
        }
        return "неизвестный";
    }
}
