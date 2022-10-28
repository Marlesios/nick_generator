package com.example.atomics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class Count {
    AtomicInteger countLengthQuantity = new AtomicInteger(0);
    List<String> countLength = new ArrayList<>();

    AtomicInteger equalNameQuantity = new AtomicInteger(0);
    List<String> equalName = new ArrayList<>();

    AtomicInteger increasingByAlphabetQuantity = new AtomicInteger(0);
    List<String> increasingByALphabet = new ArrayList<>();

    public void countLength(String[] text, int length) {

        for (String s : text) {
            if (s.length() == length) {
//
                String sample = s;
                String reverseStr = "";
                int strLength = s.length();
                for (int j = (strLength - 1); j >= 0; --j) {
                    reverseStr = reverseStr + s.charAt(j);
                }
                if (s.toLowerCase().equals(reverseStr)) {
                    countLengthQuantity.addAndGet(1);
                    countLength.add(s);
                }

            }
        }
        System.out.printf("красивых слов состоящих из %s в количестве %s \n", length, countLengthQuantity);


    }

    public void countEqualCharacterNames(String[] text) {

        for (String s : text) {
            char[] ch = s.toCharArray();
            String rev = "";
            for (int i = 0; i < ch.length; i++) {
                if (ch[0] == ch[i]) {
                    rev += ch[i];
                }
                if (rev.length() == s.length()) {
                    equalNameQuantity.addAndGet(1);
                    equalName.add(s);
                }
            }
        }
        System.out.println("количество имен с одинаковыми буквами : " + equalNameQuantity);
    }

    public void countIncreasingByAlphabet(String[] text) {
        for (String s : text) {
            char[] ch = s.toCharArray();
            char rev = 0;
            byte b = 0;
            for (int i = 0; i < ch.length; i++) {
                if (rev <= ch[i]) {
                    rev = ch[i];
                    b++;
                }
                if (b == s.length()) {
                    increasingByAlphabetQuantity.addAndGet(1);
                    increasingByALphabet.add(s);
                }
            }
        }
        System.out.println("имен состоящий по возрастанию алфавита : " + increasingByAlphabetQuantity);
    }
}
