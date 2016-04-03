package org.xuan;

/**
 * Created by xzhou2 on 4/1/16.
 */
public class MaxProdSubArray {
    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int result = Integer.MIN_VALUE;
        int prod = 1, pos = 1, neg = 1;
        boolean flag = true;
        for(int i : nums) {
            if (i == 0) {
                prod = 1;
                pos = 1;
                neg = 1;
                result = result > 0 ? result : 0;
            }
            else {
                prod *= i;
                if (prod > 0) {
                    neg = i < 0 ? (i * pos ): (neg < 0 ? i * neg :1);
                    pos = prod;
                    flag = true;
                }
                else {
                    pos = i > 0 ? (i * pos) : (neg < 0 ? (neg * i ) :  1);
                    flag = ! (i < 0 && neg > 0);
                    neg = prod;
                }
                if (flag) {
                    result = result > pos ? result : pos;
                }
            }
        }
        return result;
    }
}
