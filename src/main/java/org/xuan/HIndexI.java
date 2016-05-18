package org.xuan;

import java.util.Arrays;

/**
 * Created by xzhou2 on 5/17/16.
 */
public class HIndexI {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        if (citations[0] >= citations.length) {
            return citations.length;
        }
        if (citations[citations.length - 1] == 0) {
            return 0;
        }

        for(int i = citations.length - 1; i > 0; i-- ) {
            int index = citations.length - i;
            if (citations[index] >= i){
                return i;
            }
        }
        return 0;
    }
}
