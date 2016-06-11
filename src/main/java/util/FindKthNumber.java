package util;

/**
 * Created by xzhou2 on 6/6/16.
 */
public class FindKthNumber {
    public static int findKthNumber(int[] nums, int k) {
        return findKthNumber(nums, k, 0, nums.length - 1);
    }

    private static int findKthNumber(int[] nums, int k, int low, int high) {
        if (low >= high) {
            return nums[low];
        }

        int l = low, h = high + 1;
        int val = nums[low];
        while(l <= h) {
            while(l < high &&nums[++l] >= val);
            while(h > low && nums[--h] <= val);
            if (l >= h) {
                break;
            }
            int temp = nums[l];
            nums[l] = nums[h];
            nums[h] = temp;
        }

        nums[low] = nums[h];
        nums[h] = val;
        if (h == k) {
            return nums[h];
        }
        else if (h > k) {
            return findKthNumber(nums, k, low, h - 1);
        }
        else {
            return findKthNumber(nums, k, h + 1, high);
        }
    }
}
