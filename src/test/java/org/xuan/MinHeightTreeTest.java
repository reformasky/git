package org.xuan;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 5/26/16.
 */
public class MinHeightTreeTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                        3, new int[][]{new int[]{0,1}, new int[]{1,2}}
                }
        };
    }

    @Test(dataProvider = "data")
    public void test1(int n, int[][] edges) {
        List[] n1 = new List[1];

        n1[0] = new ArrayList<Integer>();
        Assert.assertEquals(new MinHeightTree().findMinHeightTrees(n, edges).size(), 1);
    }

    @Test
    public void test() throws IOException {
        InputStream file = this.getClass().getClassLoader().getResourceAsStream("MinHeightTree.file");
        BufferedReader reader = new BufferedReader(new InputStreamReader(file));
        String line = reader.readLine();
        line = line.substring(1, line.length() - 1);
        String[] tokens = line.split("\\],\\[");
        int[][] edges = new int[tokens.length][2];
        int i = 0;
        for(String token : tokens) {
            String[] temp = token.split(",");
            edges[i][0] = Integer.valueOf(temp[0]);
            edges[i++][1] = Integer.valueOf(temp[1]);
        }
        Assert.assertEquals(new MinHeightTree().findMinHeightTrees(5000, edges).size(), 2);
    }
}
