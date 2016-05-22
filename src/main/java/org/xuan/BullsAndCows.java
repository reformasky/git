package org.xuan;

/**
 * Created by xzhou2 on 5/22/16.
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int[] cache = new int[10];
        int bulls = 0;
        for(int i = 0; i < secret.length();i++) {
            char s = secret.charAt(i),
                    g = guess.charAt(i);
            if (s == g) {
                bulls++;
            }
            cache[s - '0']++;
            cache[g - '0']--;
        }

        int pos = 0;
        for(int i : cache){
            if (i > 0) {
                pos+=i;
            }
        }
        int cows = secret.length() - bulls - pos;
        return bulls+"A"+cows+"B";
    }
}
