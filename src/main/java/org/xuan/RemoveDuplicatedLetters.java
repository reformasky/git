package org.xuan;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xzhou2 on 6/1/16.
 */
public class RemoveDuplicatedLetters {
    public String removeDuplicateLetters_1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        char[] arr = s.toCharArray();
        for(char c : arr) {
            count[c - 'a']++;
        }
        int pos = 0;
        while(pos < arr.length) {
            for(int i = pos; i < arr.length; i++) {
                if (arr[i] == '0') {
                    continue;
                }
                if (arr[i] < pos) {
                    pos = i;
                }
                if (count[arr[i] - 'a']-- == 0) {
                    for(int j = pos + 1; j <= i; j++) {
                        if (arr[j] == '0') {
                            continue;
                        }
                        count[arr[j] - 'a']++;
                    }
                    for(int j = pos + 1; j < arr.length; j++) {
                        if (arr[j] == arr[pos]) {
                            arr[j] = '0';
                        }
                    }

                    break;
                }

            }
            sb.append(arr[pos++]);
        }
        return sb.toString();
    }

    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        char[] arr = s.toCharArray();
        for(char c : arr) {
            count[c - 'a']++;
        }
        Stack<Integer> stack = new Stack<>();
        for(char c : arr) {
            int index = c - 'a';
            count[index]--;
            if (visited[index]) {
                continue;
            }
            while (!stack.isEmpty() && index < stack.peek() && count[stack.peek()] != 0) {
                visited[stack.pop()] = false;
            }
            stack.push(index);
            visited[index] = true;
        }
        while (!stack.isEmpty()) {
            sb.append((char)(stack.pop() + 'a'));
        }

        return sb.reverse().toString();
    }
}
