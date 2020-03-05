package com.company.task7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinesWordsSymbols {

    //2. Задан текстовый файл. Вывести сколько в нём: a) строк b) слов c) символов
    static List<String> list = new ArrayList<>();
    static int countLines = 0;
    static int countWords = 0;
    static int countSymbols = 0;

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("//home//user//Документы//task7-2.txt"))) {
            String s;
            while ((s = br.readLine()) != null) {
                list.add(s);
                countLines++;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(countLines);

        counting(list);

    }

    public static void counting(List<String> list) {
        for (String s : list) {
            char[] strArr = s.toCharArray();
            for (char c : strArr) {
                countSymbols++;
                if (c == ' ') {
                    countWords++;
                }
            }
            countWords++;
        }
        System.out.println(countWords);
        System.out.println(countSymbols);
    }

}
