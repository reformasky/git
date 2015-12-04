package org.xuan;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuan on 2015/12/1.
 */
public class CountAndSay {
    private static Map<Integer, String> cache = new HashMap<>(100);
    public String countAndSay(int n) {
        if (n == 1) {
            cache.put(n, "1");
            return "1";
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        else {
            String last = countAndSay(n - 1);
            String result = say(last);
            cache.put(n, result);
            return result;
        }
    }

    private String say(String s) {
        StringBuilder sb = new StringBuilder();
        int current = s.charAt(0), count = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == current) {
                count++;
            }
            else {
                sb.append(count);
                sb.append(current - '0');
                current =s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(current - '0');
        return sb.toString();
    }
}
