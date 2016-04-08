package org.xuan;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 4/7/16.
 */
public class RevertInteger {
    public int reverseBits(int n) {
        int result = 0;
        int count = 0;
        int mask = 0;
        while(n != 0) {
            result = result << 1;
            result  |= ((n & 1) | (mask));
            n = n >>> 1;
            count++;
        }
        while(count < 32) {
            result = result << 1;
            count++;
        }
        return result;
    }
}
