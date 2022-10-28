package com.example.atomics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;


public class Count {
    AtomicInteger count = new AtomicInteger(0);
    AtomicInteger equalName = new AtomicInteger(0);
    AtomicInteger increasingByAlphabet = new AtomicInteger(0);

    String sample;
    List<String> five = new ArrayList<>();
    List<String> sameNames = new ArrayList<>();
    List<String> increasing = new ArrayList<>();

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

            char[] ch = s.toCharArray();
            String rev = "";
            for (int i = 0; i < ch.length; i++) {
                if (ch[0]==ch[i]){
                    rev += ch[i];
                }
                if (rev.length() == s.length()){
                    equalName.addAndGet(1);
                    sameNames.add(s);
                }

            }
        }

        System.out.println("количество имен с одинаковыми буквами : " + equalName);
        for (String s : sameNames) {
            System.out.println(s);
        }

    }

    public void increasingByAlphabet(String[] text){
        for (String s : text) {
            char[] ch = s.toCharArray();
            char rev = 0;
            byte b = 0;
            for (int i = 0; i < ch.length; i++) {
                if (rev <=ch[i]){
                    rev = ch[i];
                    b++;
                }
                if (b == s.length()){
                    increasingByAlphabet.addAndGet(1);
                    increasing.add(s);
                }

            }
        }
        for(String s: increasing){
            System.out.println(" этот " + s);
        }
    }

    public Integer getCount() {
        return count.get();

    }


}
