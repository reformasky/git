package org.xuan;

/**
 * Created by xuan on 2015/12/20.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        int index_l = -1, index_h = nums.length;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                index_l++;
            }
            if (nums[i] == 2) {
                index_h--;
            }
        }
        for(int i = 0; i <nums.length; i++) {
            nums[i] = i <= index_l ? 0 : (i < index_h ? 1 : 2);
        }
    }

    public void sortColors_1(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        int index_l = -1, index_h = nums.length;
        for(int i = 0; i < index_h; i++) {
            if (nums[i] == 0) {
                nums[++index_l] = 0;
            }
            else if (nums[i] == 2) {
                swap(nums, i, --index_h);
                i--;
            }
        }
        for(int i = index_l + 1; i <index_h; i++) {
            nums[i] = 1;
        }
    }

    private void swap(int[] nums, int l, int h) {
        int temp = nums[l];
        nums[l] = nums[h];
        nums[h] = temp;
    }
}
