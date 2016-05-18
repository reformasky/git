package org.xuan;

/**
 * Created by xzhou2 on 5/17/16.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        long sum = length * (length + 1) /2;
        for(int num : nums) {
            sum -= num;
        }
        return (int)sum;
    }
}
