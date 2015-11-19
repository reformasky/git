package org.xuan;

/**
 * Created by xuan on 2015/11/18.
 */
public class RemoveDuplicateFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int processedIndex = 0,currentIndex = 1;
        do {
            while(currentIndex < nums.length && nums[currentIndex] == nums[processedIndex]) {
                currentIndex++;
            }
            if (currentIndex < nums.length) {
                nums[++processedIndex] = nums[currentIndex++];
            }
            else {
                break;
            }

        } while(currentIndex < nums.length);
        return processedIndex + 1;
    }
}
