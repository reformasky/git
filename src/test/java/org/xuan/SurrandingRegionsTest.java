package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xuan on 2016/3/20.
 */
public class SurrandingRegionsTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                        new String[]{"XXXX","XOOX",  "XXOX",     "XOXX"}
                },
                {
                        new String[]{"OO","OO"}
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(String[] input) {
        char[][] transformedInput = new char[input.length][input[0].length()];
        for(int i = 0; i < input.length; i++) {
            transformedInput[i] = new char[input[0].length()];
            for(int j = 0; j < input[0].length(); j++) {
                transformedInput[i][j] = input[i].charAt(j);
            }
        }
        new SurrandingRegions().solve(transformedInput);
        for(int i = 0; i < input.length; i++) {
            for(int j = 0; j < input[0].length(); j++) {
                System.out.print(transformedInput[i][j]);
            }
            System.out.println();
        }
    }
}
