package org.xuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xuan on 2015/12/18.
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        int begin = 0;
        int sum = 0;
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            sum += word.length();
            if (sum + (i - begin) > maxWidth) {
                char[] sb = new char[maxWidth];
                Arrays.fill(sb, ' ');
                fillEvenly(sb, words, begin, i-1, maxWidth - sum + word.length());
                result.add(new String(sb));
                sum = word.length();
                begin = i;
            }
        }
        char[] sb = new char[maxWidth];
        Arrays.fill(sb, ' ');
        fillLeft(sb, words, begin, words.length - 1, maxWidth - sum);
        result.add(new String(sb));
        return result;
    }

    private void copy(char[] arr, String word, int beginIndex) {
        for(int i = 0; i < word.length(); i++) {
            arr[i + beginIndex] = word.charAt(i);
        }
    }
    private void fillEvenly(char[] arr, String[] words, int begin, int end, int spaceLength) {
        copy(arr, words[begin], 0);
        int numOfSpaces = end - begin;
        if (numOfSpaces == 0) {
            return;
        }
        int space = spaceLength  / numOfSpaces;
        int extra = spaceLength % numOfSpaces;
        int index = words[begin].length();
        for(int i = begin + 1; i <= end; i++) {
            index += space;
            if (extra >= i - begin) {
                index++;
            }
            copy(arr, words[i], index);
            index+= words[i].length();
        }
    }

    private void fillLeft(char[] arr, String[] words, int begin, int end, int spaceLength) {
        int index = 0;
        for(int i = begin; i <= end; i++) {
            copy(arr, words[i], index);
            index += words[i].length();
            index++;
        }
    }
}
