package org.xuan;

import java.util.Arrays;

/**
 * Created by xuan on 2016/3/24.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //total gas
        int g=0;
        //total cost
        int c=0;
        //current gas
        int tg=0;
        //current cost
        int tc=0;
        int ret=0;
        boolean flag = false;
        for(int i=0;i<cost.length;i++){
            g+=gas[i];
            c+=cost[i];

            tg+=gas[i];
            tc+=cost[i];
            if(gas[i]>cost[i] && !flag){
                ret = i;
                flag = true;
            }
            if(tg<tc){
                tg=0;
                tc=0;
                flag = false;
            }
        }
        if(c<=g) return ret;
        return -1;
    }
}
