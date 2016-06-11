package org.xuan;

/**
 * Created by xzhou2 on 6/2/16.
 */
public class MaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for(int size = Math.max(0, k - nums2.length); size <= Math.min(k, nums1.length); size++) {
            int[] sol1 = solve(nums1, size);
            int[] sol2 = solve(nums2, k - size);
            int[] curr = new int[k];
            int index1 = 0, index2 = 0, index = 0;
            // StringBuilder sb1 = new StringBuilder(),
            //     sb2 = new StringBuilder();
            // for(int i : sol1) {
            //     sb1.append(i);
            // }
            // for(int i : sol2) {
            //     sb2.append(i);
            // }


            // System.out.println("1=" + sb1 + " \t; 2.size=" + sb2);
            while(index < k) {

                if (compare(sol1, index1, sol2, index2)) {
                    curr[index++] = sol1[index1++];
                }
                else {
                    curr[index++] = sol2[index2++];
                }
            }
            if (compare(curr, 0, ans, 0)) {
                ans = curr;
            }
        }
        return ans;
    }

    private boolean compare(int[] nums1, int index1, int[] nums2, int index2) {
        while(index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] > nums2[index2]) {
                return true;
            }
            else if (nums1[index1] < nums2[index2]) {
                return false;
            }
            index1++;
            index2++;
        }
        return index1 == nums1.length ? false : true;
    }

    private int[] solve(int[] nums, int k) {
        int[] result = new int[k];
        int index = 0;
        int len = nums.length;
        for(int i = 0; i < nums.length; i++) {
            while(index > 0 && (nums[i] > result[index - 1]) && (len - i + index > k)) {
                index--;
            }
            if (index < k) {
                result[index++] = nums[i];
            }
        }
        return result;
    }
}
