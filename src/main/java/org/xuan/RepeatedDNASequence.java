package org.xuan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xzhou2 on 4/5/16.
 */
public class RepeatedDNASequence {
    private int dnaBaseVal(char base)  {
        if (base == 'A')
            return 0;
        else if (base == 'C')
            return 1;
        else if (base == 'G')
            return 2;
        else if (base == 'T')
            return 3;
        return 0;
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        int n = s.length();
        if (n < 10)
            return res;

        Set<Integer> vals = new HashSet<Integer>();
        Set<Integer> resVals = new HashSet<Integer>();

        int val = 0;
        for (int i = 0; i < 10; i++)    {
            val = val << 2;
            val += dnaBaseVal(s.charAt(i));
        }
        vals.add(val);

        int base = 1 << (2 * 9);
        for (int i = 10; i < n; i++)    {
            val -= base * dnaBaseVal(s.charAt(i - 10));
            val = val << 2;
            val += dnaBaseVal(s.charAt(i));
            if (!vals.add(val) && resVals.add(val))  {
                res.add(s.substring(i-9, i+1));
            }
        }

        return res;
    }
}
