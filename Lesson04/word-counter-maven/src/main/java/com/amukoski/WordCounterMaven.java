package com.amukoski;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounterMaven {
    public static void main(String[] args) {
        Map<String, Integer> wordCounterMap = new HashMap<String, Integer>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("testfile.txt"));

            String line = reader.readLine();
            while (line != null) {
                String[] words = line.split("[\\W]");      // return only words
                for (String word : words) {
                    Integer count = wordCounterMap.get(StringUtils.lowerCase(word));
                    count = count == null ? 1 : count + 1;

                    wordCounterMap.put(StringUtils.lowerCase(word), count);
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
