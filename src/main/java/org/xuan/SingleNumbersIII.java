package org.xuan;

/**
 * Created by xzhou2 on 5/16/16.
 */
public class SingleNumbersIII {
    public int[] singleNumber(int[] nums) {
        int result[] = new int[2];
        int xor = nums[0];
        for (int i=1; i<nums.length; i++)
        {
            xor ^= nums[i];
        }
        //num1 and num2 must diff at at least one digit.
        //used to find the rightMost digits that diffs.
        //xor = ...1000 ; xor - 1 = ...0111;
        //~xor = ...1000;
        //bit = ...1000;
        //therefore, this digit can differentiate num1 and num2
        int bit = xor & ~(xor-1);
        int num1 = 0;
        int num2 = 0;

        for (int num : nums)
        {
            if ((num & bit) > 0)
            {
                num1 ^= num;
            }
            else
            {
                num2 ^= num;
            }
        }

        result[0] = num1;
        result[1] = num2;
        return result;
    }
}
