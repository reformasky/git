package org.xuan;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by xzhou2 on 5/31/16.
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] results = new int[n];
        int[] pointers = new int[primes.length];
        Arrays.fill(pointers, 0);
        results[0] = 1;
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        int index = 1;
        for(int i = 0; i < primes.length;i++) {
            queue.add(new Pair(i, primes[i]));
        }
        while(!queue.isEmpty() && index < n) {
            Pair pair = queue.poll();
            int i = pair.i,
                    product = pair.product;
            if (results[index -1] != product) {
                results[index++] = product;
            }
            pointers[i]++;
            queue.add(new Pair(i, primes[i] * results[pointers[i]]));
        }

        return results[n-1];
    }

    class Pair implements Comparable<Pair>{
        int i;
        int product;

        public Pair(int i, int product) {
            this.i = i;
            this.product = product;
        }

        @Override
        public int compareTo(Pair o) {
            return this.product - o.product;
        }
    }
}
