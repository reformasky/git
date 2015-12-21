package org.xuan;

import java.util.*;

/**
 * Created by xuan on 2015/12/20.
 */
public class MinimalWindow {
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> cache = new HashMap<>();
        int remining = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (cache.containsKey(c)) {
                cache.put(c, cache.get(c) + 1);
            } else {
                cache.put(c, 1);
            }
            remining++;
        }
        int length = Integer.MAX_VALUE;
        int low = 0, high = s.length();
        boolean found = false;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cache.containsKey(c)) {
                cache.put(c, cache.get(c) - 1);
                queue.add(i);
                if (!found) {
                    if (cache.get(c) >= 0) {
                        remining--;
                    }
                    if (remining <= 0) {
                        found = true;
                    }
                }
                while (!queue.isEmpty()) {
                    c = s.charAt(queue.peek());
                    if (cache.get(c) < 0) {
                        cache.put(c, cache.get(c) + 1);
                        queue.remove();
                    } else {
                        break;
                    }
                }
                if (found && (length > i - queue.peek()+ 1)) {
                    length = i - queue.peek() + 1;
                    high = i;
                    low = queue.peek();
                }
            }
        }
        if (!found) {
            return "";
        }
        return s.substring(low, high + 1);
    }
}
