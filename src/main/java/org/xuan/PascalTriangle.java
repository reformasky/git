package org.xuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xuan on 2016/3/1.
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }

        result.add(new ArrayList<Integer>(Arrays.asList(1)));
        for(int rowNumber = 2; rowNumber <= numRows; rowNumber++) {
            Integer[] current = new Integer[rowNumber];
            current[0] = 1;
            current[rowNumber - 1] = 1;
            List<Integer> previous = result.get(rowNumber - 2);
            for(int index = 1; index < rowNumber - 1; index++) {
                current[index] = previous.get(index) + previous.get(index - 1);
            }
            result.add(Arrays.asList(current));
        }
        return result;
    }
}
