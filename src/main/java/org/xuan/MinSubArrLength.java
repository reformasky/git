package org.xuan;

/**
 * Created by xzhou2 on 4/13/16.
 */
public class MinSubArrLength {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int length = 0;
        int begin = 0;
        boolean flag = false;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            length++;
            while(sum - nums[begin] >= s) {
                sum -= nums[begin];
                begin++;
                length--;
            }
            if (sum >= s) {
                flag = true;
                result = result > length ? length: result;
            }
        }
        return result == Integer.MAX_VALUE ? (flag ? Integer.MAX_VALUE : 0) : result;
    }
}
