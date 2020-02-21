package com.company;

public class Main {

    /*
    Написать рекурсивный(!!!) метод который выводит все перестановки строки.
    Например для строки abc: abc, acb, bac, bca, cab, cba
     */

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add("string1");
        set.add("string2");
        set.add("string3");
        set.add("string4");
        set.add("string5");
        set.add("string6");
        set.add("string7");
        System.out.println(set.toString());
        set.remove("string3");
        System.out.println(set.toString());
        MyHashMap map = new MyHashMap();
        map.put("str1", "str11");
        map.put("str2", "str22");
        map.put("str3", "str33");
        map.put("str4", "str44");
        map.put("str5", "str55");
        map.put("str6", "str66");
        map.put("str7", "str77");
        System.out.println(map);
        map.remove("str3");
        System.out.println(map);
    }

}
