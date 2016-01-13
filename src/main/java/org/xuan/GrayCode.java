package org.xuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xuan on 2016/1/12.
 */
public class GrayCode {

    public List<Integer> grayCode_1(int n) {
        if (n == 0) {
            return new ArrayList(Arrays.asList(new Integer(0)));
        }
        List<Integer> result = grayCode_1(n - 1);
        int size = result.size();
        int left = 1 << (n - 1);
        for(int i = 0; i < size; i++) {
            result.add(left | result.get(size - 1 - i));
        }

        return result;
    }


    public List<Integer> grayCode(int n) {
        int size = 1 << n;
        List<Integer> result = new ArrayList<>(size);
        result.add(0);
        int currentSize = 1,digit = 1;
        while(digit <= n) {
            int left = 1 << (digit - 1);
            for(int i = currentSize - 1; i >= 0; i--) {
                result.add(left | (result.get(i)));
            }
            digit++;
            currentSize <<= 1;
        }
        return result;
    }
}
