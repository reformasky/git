package org.xuan;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xuan on 2015/12/19.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }
        Deque<String> deque = new LinkedList<>();
        String[] tokens = path.split("/");
        for(String s : tokens) {
            if (s.equals(".") || s.length() == 0) {
                continue;
            }
            if (s.equals("..") && !deque.isEmpty()) {
                deque.removeLast();
            }
            else {
                deque.addLast(s);
            }
        }
        if (deque.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();

        while(!deque.isEmpty()) {
            sb.append("/");
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }
}
