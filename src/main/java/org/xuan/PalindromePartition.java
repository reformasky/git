package org.xuan;

import util.ListNode;

import java.util.*;

/**
 * Created by xuan on 2016/3/20.
 */
public class PalindromePartition {
   Map<Integer, List<List<String>>> cache;
    public List<List<String>> partition_slow(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        cache = new HashMap<>(s.length());
        return partition(s.toCharArray(), 0);
    }

    private List<List<String>> partition(char[] transformed, int index) {
        if (cache.containsKey(index)) {
            return cache.get(index);
        }
        List<List<String>> result = new ArrayList<>();

        if (index == transformed.length) {
            return result;
        }
        for(int i = index; i < transformed.length;i++) {
            if (isPalindrome(transformed , index, i)) {
                String newString = new String(transformed, index, i - index + 1);
                List<List<String>> pre = partition(transformed, i+ 1);
                if (pre.isEmpty()) {
                    result.add(new ArrayList<String>(Arrays.asList(newString)));
                }
                else {
                    for(List<String> list : pre) {
                        List<String> curr = new ArrayList<>(list.size() + 1);
                        curr.add(newString);
                        for(String s : list) {
                            curr.add(s);
                        }
                        result.add(curr);
                    }
                }
            }
        }
        cache.put(index, result);
        return result;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
            }
        }
        helper(res, new ArrayList<String>(), dp, s, 0);
        return res;
    }

    private void helper(List<List<String>> res, List<String> path, boolean[][] dp, String s, int pos) {
        if(pos == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = pos; i < s.length(); i++) {
            if(dp[pos][i]) {
                path.add(s.substring(pos,i+1));
                helper(res, path, dp, s, i+1);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(char[] arr, int beginIndex,  int endIndex) {
        while(beginIndex < endIndex) {
            if (arr[beginIndex++] != arr[endIndex--]) {
                return false;
            }
        }
        return true;
    }
}
