package org.xuan;

/**
 * Created by xuan on 2016/3/4.
 */
public class BuyStockII {
    public int maxProfit(int[] prices) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        if (prices == null) {
            return result;
        }
        for(int price : prices) {
            if (price > min) {
                result += price - min;
            }
            min = price;
        }
        return result;
    }
}
