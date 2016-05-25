package org.xuan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xzhou2 on 5/24/16.
 */
public class RemoveInvalidParameters {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<>();
        int rmL = 0, rmR = 0;
        for(char c : s.toCharArray()) {
            if (c == '(') {
                rmL++;
            }
            if (c == ')') {
                if (rmL > 0) {
                    rmL--;
                }
                else {
                    rmR++;
                }
            }
        }
        dfs(s, 0, rmL, rmR, 0, result, new StringBuilder());
        return new ArrayList<>(result);
    }

    private void dfs(String s, int index, int rmL, int rmR, int open,Set<String> result, StringBuilder sb) {
        if (index >= s.length() && rmL == 0 && rmR == 0 && open == 0) {
            result.add(sb.toString());
            return;
        }
        if (index >= s.length() || rmL < 0 || rmR < 0 || open < 0) {
            return;
        }

        char c = s.charAt(index);
        int len = sb.length();
        if (c == '(') {
            dfs(s, index + 1, rmL - 1, rmR, open, result, sb);
            dfs(s, index + 1,rmL, rmR, open + 1, result, sb.append(c));
        }
        else if (c == ')') {
            dfs(s, index + 1, rmL, rmR - 1, open, result, sb);
            dfs(s, index + 1, rmL, rmR, open - 1, result, sb.append(c));
        }
        else {
            dfs(s, index + 1, rmL, rmR, open, result, sb.append(c));
        }
        sb.setLength(len);
    }
}
