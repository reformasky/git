package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by xzhou2 on 6/12/16.
 */
public class RussianDollEvelopesTest {


    @Test
    public void testFindIndex() {

        for (int n = 1; n < 100; n++) {
            RussianDollEvelopes game = new RussianDollEvelopes();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = 2 * i;
            }
            Arrays.sort(arr);
            for (int val = 0; val < n * 2 + 2; val++) {
                int index = game.findIndex(arr, 0, n - 1, val);
                if (index == n) {
                    if (val <= arr[n - 1]) {
                        System.out.println(val);
                        Assert.fail();
                    }
                } else if (index == 0) {
                    if (val > arr[index]) {
                        System.out.println(val);
                        Assert.fail();

                    }
                } else {
                    if (val > arr[index - 1] && val <= arr[index]) {
                    } else {
                        System.out.println(val);
                        Assert.fail();

                    }
                }
            }

        }
    }

    @Test
    public void test() {
        String s = "[[5,4],[6,4],[6,7],[2,3]]";
        String[] tokens = s.substring(2, s.length() - 2).split("\\],\\[");
        int[][] env = new int[tokens.length][2];
        for(int i = 0; i < tokens.length; i++) {
            env[i] = new int[2];
            String[] ts = tokens[i].split(",");
            env[i][0] = Integer.parseInt(ts[0]);
            env[i][1] = Integer.parseInt(ts[1]);
        }

        Assert.assertEquals(new RussianDollEvelopes().maxEnvelopes(env),3);
    }
}
