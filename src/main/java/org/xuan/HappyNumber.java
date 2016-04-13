package org.xuan;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xzhou2 on 4/11/16.
 */
public class HappyNumber {
    Set<Integer> visited = new HashSet<>();
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        if (visited.contains(n)) {
            return false;
        }
        visited.add(n);

        int next = 0;
        while(n != 0) {
            int digit = (n % 10);
            next += digit * digit;
            n = n / 10;
        }
        return isHappy(next);
    }
}
