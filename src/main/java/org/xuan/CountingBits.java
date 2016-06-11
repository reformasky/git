package org.xuan;

/**
 * Created by xzhou2 on 6/8/16.
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        int index = 1, low = 0, high = 1;
        while(index <= num) {
            if (low < high) {
                result[index++] = result[low++] + 1;
            }
            else {
                low = 0;
                high = index;
            }
        }
        return result;
    }
}
