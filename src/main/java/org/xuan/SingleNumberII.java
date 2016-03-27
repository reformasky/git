package org.xuan;

/**
 * Created by xzhou2 on 3/27/16.
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for(int i : nums) {
            for(int j = 0; j < 32; j++) {
                bits[j] += ((i >> j) & 1);
            }
        }
        for(int i = 0; i < 32;i++) {
            bits[i] %= 3;
        }

        int result = 0;
        for(int i = 0; i < 32; i++) {
            result |= bits[i] << i;
        }
        return result;
    }
}
