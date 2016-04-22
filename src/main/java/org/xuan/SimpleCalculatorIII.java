package org.xuan;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xzhou2 on 4/21/16.
 */
public class SimpleCalculatorIII {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //assume s is valid and not null;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Character> operators = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDigit(c)) {
                int operand = c - '0';
                while(i+1 < s.length() && isDigit(s.charAt(i+1))) {
                    i++;
                    operand = 10 * operand + s.charAt(i) - '0';
                }
                result.add(operand);
            }
            else if (c == '+' || c == '-') {
                while(!operators.isEmpty() && operators.peek() != '(') {
                    calculate(result, operators.pop());
                }
                operators.push(c);
            }
            else if (c == '*' || c == '/') {
                while(!operators.isEmpty()) {
                    char next = operators.peek();
                    if (next == '*' || next == '/') {
                        calculate(result, operators.pop());
                    }
                    else {
                        break;
                    }
                }
                operators.push(c);
            }
            /*else if (c == '(') {
                operators.push(c);
            }
            else if (c == ')') {
                while(operators.peek() != '(') {
                    calculate(result, operators.pop());
                }
                operators.pop();
            }*/
        }
        while(!operators.isEmpty()) {
            calculate(result, operators.pop());
        }
        return result.get(0);
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private void calculate(ArrayList<Integer> list, char c) {
        int operand2 = list.remove(list.size() - 1);
        int operand1 = list.remove(list.size() - 1);
        int result = 0;
        switch(c) {
            case '+': result = operand1 + operand2; break;
            case '-': result = operand1 - operand2; break;
            case '*': result = operand1 * operand2; break;
            case '/': result = operand1 / operand2; break;
            default: throw new RuntimeException();
        }
        list.add(result);

    }
}
