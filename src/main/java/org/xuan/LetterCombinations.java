package org.xuan;

import java.util.*;

/**
 * Created by xuan on 2015/11/22.
 */
public class LetterCombinations {
    final static Map<Character, Character[]> map =
            new HashMap<>();
    final static Set<Character> keys;
    static {
        map.put('2', new Character[]{'a','b','c'});
        map.put('3', new Character[]{'d','e','f'});
        map.put('4', new Character[]{'g','h','i'});
        map.put('5', new Character[]{'j','k','l'});
        map.put('6', new Character[]{'m','n','o'});
        map.put('7', new Character[]{'p','q','r','s'});
        map.put('8',new Character[]{'t','u','v'});
        map.put('9',new Character[]{'w','x','y','z'});
        keys = map.keySet();
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (! isValidDigits(digits)) {
            return result;
        }
        Character[] cache = new Character[digits.length()];
        letterCombinations(digits, 0, cache, result);
        return result;
    }

    private void letterCombinations(String digits, int index, Character[] cache, List<String> result) {
        if (index == digits.length() - 1) {
            for(Character c : map.get(digits.charAt(index))) {
                cache[index] = c;
                result.add(buildString(cache));
            }
        }
        else {
            for(Character c : map.get(digits.charAt(index))) {
                cache[index] = c;
                letterCombinations(digits, index + 1, cache, result);
            }
        }
    }

    private String buildString(Character[] arr) {
        StringBuilder sb = new StringBuilder(arr.length);
        for(Character c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }

    private boolean isValidDigits(String digits) {
        if (digits == null || digits.length() == 0) {
            return false;
        }
        for(int i = 0; i < digits.length();i++) {
            if (! keys.contains(digits.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
