package org.xuan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubStringAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0
                || words == null || words.length == 0) {
            return result;
        }
        if (words[0] == null || words[0].length() == 0) {
            for (Integer i = 0; i < s.length(); i++) {
                result.add(i);
                return result;
            }
        }

        Map<String, Integer> wordMap = new HashMap<>(words.length);
        Map<String, Integer> cache;
        int wordCount = 0;
        int wordLength = words[0].length();
        for (String word : words) {
            Integer count = wordMap.get(word);
            if (count != null) {
                wordMap.put(word, count + 1);
            } else {
                wordMap.put(word, 1);
            }
        }

        for (int i = 0; i < wordLength; i++) {
            int left = i;
            cache = new HashMap<>();
            wordCount = 0;
            for (int j = left; j <= s.length() - wordLength; j += wordLength) {
                String currentWord = s.substring(j, j + wordLength);
                if (wordMap.containsKey(currentWord)) {
                    wordCount++;
                    Integer count = cache.get(currentWord);
                    if (count == null) {
                        cache.put(currentWord, 1);
                    } else {
                        cache.put(currentWord, 1 + count);
                    }

                    while (cache.get(currentWord) > wordMap.get(currentWord)) {
                        String leftWord = s.substring(left, left + wordLength);
                        cache.put(leftWord, cache.get(leftWord) - 1);
                        left += wordLength;
                        wordCount--;
                    }
                    if (wordCount == words.length) {
                        result.add(left);
                        String leftWord = s.substring(left, left + wordLength);
                        cache.put(leftWord, cache.get(leftWord) - 1);
                        left += wordLength;
                        wordCount--;
                    }
                } else {
                    left = j + wordLength;
                    cache.clear();
                    wordCount = 0;
                }
            }
        }
        return result;
    }
}
