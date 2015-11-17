package org.xuan;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuan on 2015/11/13.
 */
public class RomanToInt {
    static Map<Character, Integer> map = new HashMap<Character, Integer>();
    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        int currentValue;
        int nextValue = map.get(s.charAt(0));
        for(int i = 0; i < s.length() - 1; i++) {
            currentValue = nextValue;
            nextValue = map.get(s.charAt(i+1));
            if (currentValue < nextValue) {
                result -= currentValue;
            }
            else {
                result += currentValue;
            }
        }
        result += map.get(s.charAt(s.length() - 1));
        return result;
    }
}
