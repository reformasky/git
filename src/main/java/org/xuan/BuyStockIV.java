package org.xuan;

import java.util.Arrays;

/**
 * Created by xzhou2 on 4/7/16.
 */
public class BuyStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) {
            return 0;
        }
        if (k > prices.length / 2) { // in this case, it's the same problem as Best Time to Buy & Sell Stock II
            int max = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                int diff = prices[i + 1] - prices[i];
                max += diff>0 ? diff : 0;
            }
            return max;
        }
        int[] sell = new int[k];
        int[] buy = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, 0);
        for(int price : prices) {
            for(int i = k -1; i > 0; i--) {
                sell[i] = Math.max(sell[i], buy[i] + price);
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
            }
            sell[0] = Math.max(sell[0], buy[0] + price);
            buy[0] = Math.max(buy[0], -price);
        }
        int result = Integer.MIN_VALUE;
        for(int s : sell) {
            result = Math.max(s, result);
        }
        return result;
    }
}
