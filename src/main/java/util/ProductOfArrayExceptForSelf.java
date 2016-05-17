package util;

/**
 * Created by xzhou2 on 4/26/16.
 */
public class ProductOfArrayExceptForSelf {
    public int[] productExceptSelf(int[] nums) {
        int left = 1, right = 1;
        int n = nums.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            result[i] = left;
            left *= nums[i];
        }
        for(int i = n -1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }
}
