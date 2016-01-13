package org.xuan;

/**
 * Created by xuan on 2015/12/23.
 */
public class RemoveDuplicateFromSortedArray_2 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int currentValue = nums[0];
        int count = 1;
        int currentIndex = 0;
        nums[currentIndex++] = currentValue;
        for(int i= 1; i < nums.length; i++) {

            if (nums[i] != currentValue){
                currentValue = nums[i];
                count = 1;
            }
            else{
                count++;
                if (count >= 2) {
                    while(i < nums.length && nums[i] == currentValue){i++;}
                    i--;
                }
            }
            nums[currentIndex++] = currentValue;

        }
        return currentIndex;
    }
}
