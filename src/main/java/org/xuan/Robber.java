package org.xuan;

/**
 * Created by xzhou2 on 4/8/16.
 */
public class Robber {
    public int rob(int[] values) {
        if (values.length == 0) {
            return 0;
        }
        int pre = 0, curr = 0;
        for(int v : values) {
            int temp = curr;
            curr = Math.max(curr, pre + v);
            pre = temp;
        }
        return curr;
    }
}
