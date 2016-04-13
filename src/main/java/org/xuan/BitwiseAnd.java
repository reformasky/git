package org.xuan;

/**
 * Created by xzhou2 on 4/10/16.
 */
public class BitwiseAnd {
    public int rangeBitwiseAnd(int m, int n) {
        int mask = 0x80000000;
        int result = 0;
        for(int i = 0; i < 32; i++) {
            if ((mask & m) != (mask & n)) {
                break;
            }
            result |= (mask & m &n);
            mask = mask >>>1;
        }
        return result;
    }
}
