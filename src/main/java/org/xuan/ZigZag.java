package org.xuan;

/**
 * Created by xuan on 2015/11/10.
 */
public class ZigZag {

    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || s.length() < numRows || numRows <= 1) {
            return s;
        }
        //StringBuilder sb = new StringBuilder(s.length());
        char[] cache = new char[s.length()];
        int index = 0;
        int currentIndex = 0;
        int position;
        for(int row = 0; row < numRows; row++) {
            currentIndex = row;
            while(currentIndex < s.length()) {
                cache[index++ ] = s.charAt(currentIndex);
                if ( row != 0 && row != numRows - 1 ) {
                    position = currentIndex + (2 * numRows - 2 * row  - 2);
                    if(position < s.length())
                        cache[index++] = s.charAt(position);
                }
                currentIndex += 2 * numRows - 2;
            }
        }
        return new String(cache);
    }
}
