package org.xuan;

import java.util.Stack;

/**
 * Created by xzhou2 on 4/20/16.
 */
public class SimpleCalculator {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(int i = 0; i < s.length();i++) {
            char c = s.charAt(i);
            if (isDigit(c)) {
                int operand = c - '0';
                while(i + 1 < s.length() && isDigit(s.charAt(i+1))) {
                    operand = operand * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                operands.push(operand);

                if (!operators.isEmpty() && operators.peek() != '(') {
                    calculate(operands, operators.pop());
                }
            }
            else if (c == '+' || c == '-') {
                operators.push(c);
            }
            else if (c == '(') {
                operators.push(c);
            }
            else if (c == ')'){
                boolean first = false;
                while(!operators.isEmpty()) {
                    c = operators.pop();
                    if (c == '(') {
                        if (!first) {
                            first = true;
                            continue;
                        }
                        else {
                            operators.push(c);
                            break;
                        }

                    }
                    calculate(operands, c);
                }
            }
        }
        if (!operators.isEmpty()) {
            calculate(operands, operators.pop());
        }
        return operands.pop();
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
    private void calculate(Stack<Integer> operands, char c) {
        int operand2 = operands.pop();
        int operand1 = operands.pop();
        if (c == '+') {
            operands.push(operand1 + operand2);
        }
        else {
            operands.push(operand1 - operand2);
        }
    }
}
