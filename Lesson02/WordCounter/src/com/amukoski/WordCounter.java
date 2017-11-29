package com.amukoski;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static void main(String[] args) {
        Map<String, Integer> wordCounterMap = new HashMap<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("testfile.txt"));

            String line = reader.readLine();
            while (line != null) {
                String[] words = line.split("[\\W]");      // return only words
                for (String word : words) {
                    Integer count = wordCounterMap.get(word.toLowerCase());
                    count = count == null ? 1 : count + 1;

                    wordCounterMap.put(word.toLowerCase(), count);
                }

                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        for (Map.Entry<String, Integer> pair : wordCounterMap.entrySet()) {
            System.out.printf("%s:%d\n", pair.getKey(), pair.getValue());
        }

    }
}
