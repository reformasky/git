package org.xuan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xzhou2 on 5/20/16.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] map = new String[26];
        Set<String> set = new HashSet<>(26);
        String[] tokens = str.split(" ");
        if (tokens.length != pattern.length()) {
            return false;
        }
        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = tokens[i];
            if (map[c - 'a'] == null) {
                if (set.contains(s)) {
                    return false;
                }
                set.add(s);
                map[c - 'a'] = s;
            }
            else {
                if (!(set.contains(s) && map[c - 'a'].equals(s))) {
                    return false;
                }
            }
        }
        return true;
    }
}
