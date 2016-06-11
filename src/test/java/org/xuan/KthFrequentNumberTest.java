package org.xuan;

import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by xzhou2 on 5/30/16.
 */
public class KthFrequentNumberTest {
   private List<Integer> control(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap<>();
       for(int num : nums) {
           if (map.containsKey(num)) {
               map.put(num, map.get(num) + 1);
           }
           else {
               map.put(num, 1);
           }
       }

       Integer[] values = new Integer[map.keySet().size()];
       int index = 0;
       for(int key : map.keySet()) {
           values[index++] = map.get(key);
       }

       Arrays.sort(values, (p,q) ->(q - p));
       int value = values[k - 1];
       List<Integer> result = new ArrayList<>(k);
       List<Integer> equal = new ArrayList<>();
       for(int key : map.keySet()) {
           if (map.get(key) > value) {
               result.add(key);
           }
           else if (map.get(key) == value) {
               equal.add(key);
           }
       }
       int diff = k - result.size();
       for(int i = 0; i < diff; i++) {
           result.add(equal.get(i));
       }
       return result;

   }

    @Test
    public void test() {
        int len = 100;
        Random random = new Random();
        int[] values = new int[len],
                copy = new int[len];
        for(int i = 0; i < len; i++) {
            int v = random.nextInt(len/2);
            values[i] = v;
            copy[i] = v;
        }
        for(int i = 1; i < 15; i++) {
            List<Integer> result = new KFrequestNumber().topKFrequent(values, i);
            List<Integer> con = control(values, i);
            Assert.assertEquals(result.size(), con.size());
        }



    }
}
