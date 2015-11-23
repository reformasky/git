package org.xuan;

/**
 * Created by xuan on 2015/11/19.
 */
public class MergeSortedArray {
    public void merge(int[] first, int m, int[] second, int n) {
        if (n == 0) {
            return;
        }
        for(int i = m - 1; i >= 0; i--) {
            first[i+n] = first[i];
        }

        int firstIndex = n, secondIndex = 0, currentIndex = 0;
        while(firstIndex < n + m && secondIndex < n) {
            if (first[firstIndex] < second[secondIndex]) {
                first[currentIndex++] = first[firstIndex++];
            }
            else {
                first[currentIndex++] = second[secondIndex++];
            }
        }
        while(secondIndex < n) {
            first[currentIndex++] = second[secondIndex++];
        }
    }
}
