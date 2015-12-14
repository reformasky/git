package org.xuan;

import java.util.*;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }

        Map<String, ArrayList<String>> temp = new HashMap<>();
        for(String str : strs) {
            String firstAnagram = firstAnagram(str);
            if (temp.containsKey(firstAnagram)) {
                temp.get(firstAnagram).add(str);
            }
            else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                temp.put(firstAnagram, list);
            }
        }
        for(String str : temp.keySet()) {
            ArrayList<String> currentlist = temp.get(str);
            String[] strArr = new String[currentlist.size()];
            currentlist.toArray(strArr);
            Arrays.sort(strArr);
            result.add(Arrays.asList(strArr));
        }
        return result;
    }
    private String firstAnagram(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
