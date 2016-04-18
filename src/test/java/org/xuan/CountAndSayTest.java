package org.xuan;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuan on 2015/12/1.
 */
public class CountAndSayTest {

    @Test
    public void test() {
        String result = new CountAndSay().countAndSay(2);
        Assert.assertEquals(result,"11");
    }

    @Test
    public void test2() {
        int[][] arr = new int[][]{new int[]{1,2}, new int[]{1,3}, new int[]{-2,3}};
        Arrays.sort(arr, new ArrComparator());
        System.out.print(arr);
        List<Integer>[] arr1 = (ArrayList<Integer>[])(new Object[1]);
    }

    class ArrComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            int[] arr1 = (int[]) o1;
            int[] arr2 = (int[]) o2;
            if (arr1[0] > arr2[0]) {
                return 1;
            }
            else if (arr1[0] < arr2[0]) {
                return  -1;
            }
            else {
                return arr1[1] - arr2[1];
            }
        }
    }
}
