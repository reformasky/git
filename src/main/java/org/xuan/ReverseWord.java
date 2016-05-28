package org.xuan;

/**
 * Created by xzhou2 on 3/31/16.
 */
public class ReverseWord {
    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        String[] tokens = s.split(" ");
        StringBuilder sb = new StringBuilder(s.length());
        for(int i = tokens.length -1; i > 0; i--) {
            if (tokens[i].length() != 0) {
                sb.append(tokens[i]);
                sb.append(" ");
            }

        }
        if (tokens.length != 0 && tokens[0].length()!= 0) {
            sb.append(tokens[0]);
        }
        else if(sb.length() > 0){
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
