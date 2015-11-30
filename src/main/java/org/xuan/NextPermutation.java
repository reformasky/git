package org.xuan;

/**
 * Created by xuan on 2015/11/28.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
       for(int left = nums.length - 2; left >= 0; left--) {
           for (int right = nums.length - 1; right > left; right--) {
               if (nums[left] < nums[right]) {
                   permutate(nums, left,right);
                   return;
               }
           }
       }
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int left , int right) {
        //assert left <= right;
        for(int i = left; i <= (left + right) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[right - i + left];
            nums[right - i + left] = temp;
        }
    }

    private void permutate(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
        reverse(nums, left + 1, nums.length - 1);
    }
}
