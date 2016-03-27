package org.xuan;

/**
 * Created by xuan on 2016/3/24.
 */
public class SingleNumbers {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result ^= i;
        }
        return result;
    }
}
