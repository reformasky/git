package org.xuan;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 4/4/16.
 */
public class FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        int n = numerator, d = denominator;
        if (n == 0) return "0";
        int sign = (n ^ d) >>> 31;
        StringBuilder ans = new StringBuilder();
        if (sign != 0) ans.append('-');
        Long ln = Math.abs(Long.valueOf(n)), ld = Math.abs(Long.valueOf(d));
        ans.append(ln / ld);
        Long rem = ln % ld;
        if (rem == 0) return ans.toString();
        ans.append('.');
        rem *= 10;
        Map<Long, Integer> numeratorIndex = new HashMap<>();  // <numerator, index> pair
        StringBuilder decimal = new StringBuilder();
        for (int idx = 0; rem != 0; ++idx) {
            if (!numeratorIndex.containsKey(rem)) {
                numeratorIndex.put(rem, idx);
                decimal.append(rem / ld);
                rem = (rem % ld) * 10;
            } else {
                decimal.insert((int)(numeratorIndex.get(rem)), '(');
                decimal.append(')');
                break;
            }
        }
        ans.append(decimal);
        return ans.toString();
    }
}
