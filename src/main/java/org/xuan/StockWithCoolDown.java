package org.xuan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 5/25/16.
 */
public class StockWithCoolDown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <2 ) {
            return 0;
        }

        int inclusive = 0, exclusive = 0;
        for(int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            int newInclusive = Math.max(inclusive + profit, exclusive);
            int newExclusive = Math.max(inclusive, exclusive);
            inclusive = newInclusive;
            exclusive = newExclusive;
        }
        return Math.max(inclusive, exclusive);
    }
}
