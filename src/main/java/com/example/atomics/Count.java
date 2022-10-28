package com.example.atomics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;



public class Count {
    AtomicInteger count = new AtomicInteger(0);
    AtomicInteger equalName = new AtomicInteger(0);
    String sample;
    List<String> five = new ArrayList<>();
    List<String> sameNames = new ArrayList<>();

    public void setCount(String[] text, int length) {
        for (String s : text) {
            if (s.length() == length) {
//
                sample = s;
                String reverseStr = "";
                int strLength = s.length();
                for (int j = (strLength - 1); j >= 0; --j) {
                    reverseStr = reverseStr + s.charAt(j);
                }
                if (s.toLowerCase().equals(reverseStr)) {
                    count.addAndGet(1);
                    five.add(s);
                }

            }
        }

        System.out.printf("красивых слов состоящих из %s в количестве %s \n", length, count);


    }
    public void sameName(String[] text) {
        for (String s : text) {
            char[] current = s.toCharArray();
            int count = 0;
                for(int i= 0; i < current.length; i++){
                    for(int j = i + 1; j < current.length; j++){
                        char one = current[j];
                        if(current[i] == one){
                            count += 1;
                        }
                    }
                }
                if(current.length  == count){
                    equalName.addAndGet(1);
                    sameNames.add(s);
                }
        }

        System.out.println("количество имен с одинаковыми буквами : "+equalName);
        for(String s: sameNames){
            System.out.println(s);
        }
    }

    public Integer getCount() {
        return count.get();

    }


}
