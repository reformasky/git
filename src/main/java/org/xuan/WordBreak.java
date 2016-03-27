package org.xuan;

import java.util.Set;

/**
 * Created by xzhou2 on 3/26/16.
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (wordDict == null || wordDict.isEmpty()) {
            return false;
        }
        int length = s.length();
        boolean[] cache = new boolean[length];
        for (int i = 0; i < length; i++) {
            boolean match = false;
            if (wordDict.contains(s.substring(0, i + 1))) {
                match = true;
                cache[i] = true;
                continue;
            }
            for (String curr : wordDict) {
                if (curr.length() > i + 1) {
                    continue;
                }
                if ((i < curr.length() || cache[i - curr.length()]) && s.substring(i - curr.length() + 1, i + 1).equals(curr)) {
                    match = true;
                    cache[i] = true;
                    break;
                }
            }

        }
        return cache[length - 1];
    }
}
