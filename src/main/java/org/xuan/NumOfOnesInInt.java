package org.xuan;

/**
 * Created by xzhou2 on 4/7/16.
 */
public class NumOfOnesInInt {
    public int hammingWeight(int n) {
        int result = 0;
        while(n != 0) {
            result += (n & 1);
            n = n >>> 1;
        }
        return result;
    }
}
