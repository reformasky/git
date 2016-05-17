package org.xuan;

import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by xzhou2 on 4/25/16.
 */
public class MajorityElementIITest {
    @Test
    public void test() {
        for(int s = 0; s < 5; s++) {
            int[] n = new int[] {999, 1000, 1001};
            Random random = new Random(s);
            for(int i = 0; i < n.length; i++) {
                int[] nums = new int[n[i]];
                for(int j = 0; j < nums.length; j++) {
                    nums[j] = random.nextInt(3);
                }
                int[] v = new int[4];
                for(int j : nums) {
                    v[j]++;
                }

                for(int value : v) {
                    System.out.print(value + " ");
                }
                System.out.println();

                System.out.println(new MajorityElementII().majority(nums));
            }
        }

    }

}
