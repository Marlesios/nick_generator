package com.example.atomics;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 4 + random.nextInt(3));
        }


        Count count = new Count();
        Thread thread1 = new Thread(null, () -> count.countLength(texts, 5), "mark");
        Thread thread2 = new Thread(null, () -> count.countEqualCharacterNames(texts), "mark2");
        Thread thread3 = new Thread(null, () -> count.countIncreasingByAlphabet(texts), "marl3");
        thread1.start();
        thread2.start();
        thread3.start();
        thread3.join();
        thread2.join();
        thread1.join();
    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

}
