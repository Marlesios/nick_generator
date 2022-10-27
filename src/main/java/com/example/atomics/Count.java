package com.example.atomics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class Count {
    AtomicInteger count = new AtomicInteger(0);
    //    int sampleInt;
    String sample;
    List<String> five = new ArrayList<>();

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

    public Integer getCount() {
        return count.get();

    }


}
