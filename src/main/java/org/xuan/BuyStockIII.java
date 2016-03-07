package org.xuan;

/**
 * Created by xuan on 2016/3/4.
 */
public class BuyStockIII {
    public int maxProfitOriginal(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] singles = new int[prices.length];
        int[] doubles = new int[prices.length];
        singles[0] = 0;
        doubles[0] = 0;
        int min = prices[0];
        int secondMinIndex = 0;
        int minIndexAfterMax = 0;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (price < min) {
                min = price;
            }
            if (price < prices[minIndexAfterMax]) {
                minIndexAfterMax = i;
            }
            singles[i] = Math.max(singles[i - 1], price - min);

            doubles[i] = doubles[i - 1];
            int choice;
            choice = price - prices[secondMinIndex] + singles[secondMinIndex];
            if (choice >= doubles[i]) {
                doubles[i] = choice;
            }
            choice = price - prices[minIndexAfterMax] + singles[minIndexAfterMax];
            if (choice >= doubles[i]) {
                doubles[i] = choice;
                secondMinIndex = minIndexAfterMax;
            }
            if (doubles[i] > doubles[i - 1]) {
                minIndexAfterMax = i;
            }
        }
        return doubles[prices.length - 1];
    }

    public int maxProfit_O_N(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int buy1 = Integer.MIN_VALUE, sell1 = 0, buy2 = Integer.MIN_VALUE, sell2 = 0;
        for (int price : prices) {
            sell2 = Math.max(sell2, buy2 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell1 = Math.max(sell1, buy1 + price);
            buy1 = Math.max(buy1, -price);
        }
        return Math.max(sell1, sell2);
    }
}
