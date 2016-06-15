package org.xuan;

/**
 * Created by xzhou2 on 6/12/16.
 */
public class MinPatch {
    public int minPatches(int[] nums, int n) {
        int result = 0;
        long sum = 0l;
        int index = 0;
        long target = 0l;
        while(index < nums.length && sum < n) {
            target = sum + 1;
            while(index < nums.length && nums[index] <= Math.min(n, target)) {
                sum += nums[index++];
            }
            if (sum < target) {
                result++;
                sum += target;
            }
        }
        while(sum < n) {
            result++;
            sum += sum + 1;
        }
        return result;
    }
}
