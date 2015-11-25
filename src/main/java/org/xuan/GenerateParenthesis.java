package org.xuan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuan on 2015/11/23.
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        generate(result, "", n, n);
        return result;
    }

    private void generate(List<String> cache, String sb, int left, int right) {
        if (left == 0 && right == 0) {
            cache.add(sb.toString());

        }
        if (left > 0) {
            generate(cache, sb + "(", left - 1, right);
        }
        if (right > left) {
            generate(cache, sb + ")", left, right - 1);
        }
    }
}
