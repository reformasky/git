package org.xuan;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xuan on 2016/3/1.
 */
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return Arrays.asList(1);
        }

        Integer[] cache = null;
        Integer[] result = new Integer[rowIndex + 1];
        result[0] = 1;
        for(int rowNumber = 1; rowNumber <= rowIndex; rowNumber++) {
            result[rowNumber] = 1;
            for(int index = 1; index < rowNumber; index++) {
                result[index] = cache[index] + cache[index -1];
            }
            cache = Arrays.copyOfRange(result, 0, rowNumber + 1);
        }
        return Arrays.asList(result);
    }

    public List<Integer> getRow_NoCopy(int rowIndex) {
        if (rowIndex == 0) {
            return Arrays.asList(1);
        }
        Integer[] cache = null;
        Integer[] result = new Integer[rowIndex + 1];
        result[0] = 1;
        for(int rowNumber = 1; rowNumber <= rowIndex; rowNumber++) {
            result[rowNumber] = 1;
            int temp = result[0];
            int previous;
            for(int index = 1; index < rowNumber; index++) {
                previous = temp;
                temp = result[index];
                result[index] = previous + result[index];
            }
        }
        return Arrays.asList(result);
    }


}
