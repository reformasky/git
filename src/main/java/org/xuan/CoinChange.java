package org.xuan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 6/5/16.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return 0;
        }

        int[] cache = new int[amount + 1];
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = 0;
        for(int a = 1; a <= amount; a++) {
            for(int coin : coins) {
                if (coin <= a && cache[a - coin] != Integer.MAX_VALUE) {
                    cache[a] = Math.min(cache[a], cache[a - coin] + 1);
                }
            }
        }
        return cache[amount] == Integer.MAX_VALUE ? -1 : cache[amount];
    }
}
