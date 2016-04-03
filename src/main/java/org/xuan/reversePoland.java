package org.xuan;

import java.util.Stack;

/**
 * Created by xzhou2 on 3/31/16.
 */
public class reversePoland {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> numbers = new Stack<>();
        for(String s : tokens) {
            if (s.length() == 1 && s.charAt(0) <'0') {
                int n1 = numbers.pop();
                int n2 = numbers.pop();
                switch(s.charAt(0)) {
                    case '+': numbers.push(n1 + n2); break;
                    case '-': numbers.push(n2 - n1); break;
                    case '*': numbers.push(n2 * n1); break;
                    case '/': numbers.push(n2 / n1); break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
            else {
                numbers.push(Integer.parseInt(s));
            }
        }
        return numbers.pop();
    }
}
