package org.xuan;

import java.util.*;

/**
 * Created by xuan on 2016/3/6.
 */
public class WordLadderI {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (wordList.isEmpty() || beginWord.length() == 0) {
            return 0;
        }
        wordList.add(endWord);
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(beginWord, 1));
        while(!queue.isEmpty()) {
            Pair curr = queue.remove();
            String s = curr.s;
            int v = curr.v;
            for(int i = 0; i < beginWord.length();i++) {
                char[] str = s.toCharArray();
                for(int c = 'a'; c <= 'z'; c++) {
                    if (c == str[i]) {
                        continue;
                    }
                    str[i] = (char)c;
                    String newString = new String(str);
                    if (wordList.contains(newString)) {
                        wordList.remove(newString);
                        queue.add(new Pair(newString, v + 1));
                    }
                }
            }
            if (! wordList.contains(endWord)) {
                return v + 1;
            }
        }
        return 0;
    }

    public int ladderLength_better(String start, String end, Set<String> dict) {
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();

        set1.add(start);
        set2.add(end);

        return helper(dict, set1, set2, 1);
    }

    int helper(Set<String> dict, Set<String> set1, Set<String> set2, int level) {
        if (set1.isEmpty()) return 0;

        if (set1.size() > set2.size()) return helper(dict, set2, set1, level);

        // remove words from both ends
        for (String word : set1) { dict.remove(word); };
        for (String word : set2) { dict.remove(word); };

        // the set for next level
        Set<String> set = new HashSet<String>();

        // for each string in the current level
        for (String str : set1) {
            for (int i = 0; i < str.length(); i++) {
                char[] chars = str.toCharArray();

                // change letter at every position
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String word = new String(chars);

                    // found the word in other end(set)
                    if (set2.contains(word)) {
                        return level + 1;
                    }

                    // if not, add to the next level
                    if (dict.contains(word)) {
                        set.add(word);
                    }
                }
            }
        }

        return helper(dict, set2, set, level + 1);
    }

    class Pair{
        String s;
        int v;

        public Pair(String s, int v) {
            this.s = s;
            this.v = v;
        }
    }
}
