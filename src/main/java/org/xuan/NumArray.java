package org.xuan;

/**
 * Created by xzhou2 on 5/23/16.
 */
public class NumArray {
    private int[] left;
    private int[] right;
    int total;
    int len;
    public NumArray(int[] nums) {
        len = nums.length;
        left = new int[len];
        right = new int[len];
        total = 0;

        for(int i = 0; i < nums.length; i++) {
            total += nums[i];
            left[i] = total;
        }
        for(int i = 1; i < nums.length; i++) {
            right[i] = total - left[i -1];
        }
    }

    public int sumRange(int i, int j) {
        int l = (i > 0) ? left[i-1] : 0,
                r = (j < len -1) ? right[j + 1] : 0;
        return total - l - r;
    }
}
