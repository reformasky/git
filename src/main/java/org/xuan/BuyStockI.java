package org.xuan;

/**
 * Created by xuan on 2016/3/4.
 */
public class BuyStockI {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] singles = new int[prices.length];
        int[] doubles = new int[prices.length];
        int min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            else {
                singles[i] = prices[i] - min > prices[i-1] ? (prices[i] - min) : prices[i-1];
            }
            int max = doubles[i -1];
            for(int j = 0; j < i -1; j++) {
                if (prices[j + 1] < prices[i]) {
                    int temp = prices[i] - prices[j + 1] + singles[j];
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
            doubles[i] = max > singles[i] ? max : singles[i];
        }

        return doubles[prices.length - 1];
    }
}
