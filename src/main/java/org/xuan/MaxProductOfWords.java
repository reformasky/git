package org.xuan;

import java.util.Arrays;

/**
 * Created by xzhou2 on 5/31/16.
 */
public class MaxProductOfWords {
    public int maxProduct(String[] words) {
        int max = 0;

        Arrays.sort(words,(p, q) -> (q.length() - p.length()));

        int[] masks = new int[words.length]; // alphabet masks

        for(int i = 0; i < masks.length; i++){
            for(char c: words[i].toCharArray()){
                masks[i] |= 1 << (c - 'a');
            }
        }

        for(int i = 0; i < masks.length; i++){
            if(words[i].length() * words[i].length() <= max) break; //prunning
            for(int j = i + 1; j < masks.length; j++){
                if((masks[i] & masks[j]) == 0){
                    max = Math.max(max, words[i].length() * words[j].length());
                    break; //prunning
                }
            }
        }

        return max;
    }
}
