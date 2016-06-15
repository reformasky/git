package org.xuan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by xzhou2 on 6/14/16.
 */
public class ReconstructInventory {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<String>();
        if(tickets == null || tickets.length == 0){
            return result;
        }

        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(String[] ticket : tickets) {
            String ori = ticket[0], des = ticket[1];
            if (!map.containsKey(ori)) {
                map.put(ori, new PriorityQueue<String>());
            }
            map.get(ori).offer(des);
        }
        Stack<String> last = new Stack<>();
        String ori = "JFK";
        for(int i = 0; i < tickets.length; i++) {
            while(map.get(ori) == null || map.get(ori).isEmpty()) {
                last.push(ori);
                ori = result.remove(result.size() - 1);
            }
            result.add(ori);
            ori = map.get(ori).poll();
        }
        result.add(ori);
        while(!last.isEmpty()) {
            result.add(last.pop());
        }
        return result;
    }
}
