package org.xuan;

/**
 * Created by xzhou2 on 3/26/16.
 */
public class Candy {
    public int candy(int[] ratings) {
        int length = ratings.length;
        if (ratings == null || length == 0) {
            return 0;
        }
        int result = 1;
        int currentValue = 1;
        int peak = 0, bottom = 0, previousBottom = 0;

        for (int i = 1; i < length; i++) {
            int rate = ratings[i];
            int pre = ratings[i - 1];
            if (pre < rate) {
                result += ++currentValue;
                peak = i;
                previousBottom = bottom;
            } else if (pre == rate) {
                currentValue = 1;
                result += currentValue;
                peak = i;
                bottom = i;
                previousBottom = i;
            } else {
                currentValue = 1;
                result += (i - peak);
                if (i - peak > peak - previousBottom) {
                    result++;
                }
                bottom = i;
            }
        }
        return result;
    }
}
