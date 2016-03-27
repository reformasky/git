package org.xuan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Created by xzhou2 on 3/27/16.
 */
public class WordBreakII {
    Map<Integer, List<List<String>>> cache;

    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        cache = new HashMap<>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return result;
        }

        List<List<String>> temp = wordBreak(s, wordDict, 0);
        for (List<String> list : temp) {
            if (list != null && !list.isEmpty()) {
                StringBuilder sb = new StringBuilder(s.length() * 2);
                for (int i = list.size() - 1; i > 0; i--) {
                    sb.append(list.get(i));
                    sb.append(' ');
                }
                sb.append(list.get(0));
                result.add(sb.toString());
            }
        }
        return result;
    }

    private List<List<String>> wordBreak(String s, Set<String> wordDict, int beginIndex) {
        if (cache.containsKey(beginIndex)) {
            return cache.get(beginIndex);
        }
        if (beginIndex >= s.length()) {
            List<List<String>> result = new ArrayList<>();
            result.add(new ArrayList<String>());
            return result;
        }
        List<List<String>> result = new ArrayList<>();
        for (int i = beginIndex; i < s.length(); i++) {
            String sub = s.substring(beginIndex, i + 1);
            if (wordDict.contains(sub)) {
                List<List<String>> pre = wordBreak(s, wordDict, i + 1);
                for (List<String> list : pre) {
                    List<String> copy = new ArrayList<>(list);
                    copy.add(sub);
                    result.add(copy);
                }
            }
        }

        cache.put(beginIndex, result);
        return result;
    }


}
