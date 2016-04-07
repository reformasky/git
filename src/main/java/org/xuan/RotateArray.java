package org.xuan;

/**
 * Created by xzhou2 on 4/6/16.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        if (k ==0) {
            return;
        }
        for(int i = 0; i < gcd(k, length); i++){
            int j = i;
            int temp = nums[j];
            do{
                int nextIndex = (j + k + length) % length;
                int pre = nums[nextIndex];
                nums[nextIndex] = temp;
                temp = pre;
                j = nextIndex;
            }while(j != i);
        }
    }

    int gcd(int a, int b) {
        int r;
        while(b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
