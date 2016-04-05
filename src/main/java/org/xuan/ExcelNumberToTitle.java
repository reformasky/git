package org.xuan;

/**
 * Created by xzhou2 on 4/4/16.
 */
public class ExcelNumberToTitle {
    public String convertToTitle(int n) {
        if(n ==0) {
            return "";
        }
        StringBuilder sb = new StringBuilder() ;
        while(n > 0) {
            int remainder = (n-1)%26;
            sb.append((char)('A' + remainder));
            n = (n-remainder+1)/26;
        }
        return sb.reverse().toString();
    }
}
