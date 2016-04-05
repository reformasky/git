package org.xuan;

/**
 * Created by xzhou2 on 4/4/16.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int index = nums.length;
        while(index > 2) {
            int temp = index;
            index = 0;
            int boundary = (temp % 2 == 0) ? temp : temp - 1;
            for(int i = 0; i < boundary; i += 2) {
                if (nums[i] == nums[i+1]) {
                    nums[index++] = nums[i];
                }
            }
            if(temp % 2 != 0) {
                nums[index++] = nums[boundary];
            }
        }
        return nums[0];
    }
}
