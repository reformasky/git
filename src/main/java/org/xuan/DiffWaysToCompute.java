package org.xuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 5/16/16.
 */
public class DiffWaysToCompute {
    List<Integer>[][] cache;
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> operands = new ArrayList<>();
        List<Character> operators = new ArrayList();
        List<Integer> result = new ArrayList<>();
        parse(input, operands, operators);
        if (operands.size() == 0) {
            return result;
        }
        cache = (List<Integer>[][])new List[operands.size()][operands.size()];
        for(int i = 0; i < operands.size(); i++) {
            cache[i][i] = new ArrayList<Integer>(Arrays.asList(operands.get(i)));
        }
        return diffWaysToCompute(operands, operators, 0, operands.size() - 1);
    }

    private List<Integer> diffWaysToCompute(List<Integer> operands, List<Character> operators, int begin, int end) {
        if (cache[begin][end] != null) {
            return cache[begin][end];
        }

        List<Integer> result = new ArrayList<>();
        for(int i = begin; i < end; i++) {
            List<Integer> lefts = diffWaysToCompute(operands, operators, begin, i),
                    rights = diffWaysToCompute(operands, operators, i + 1, end);
            for(Integer left : lefts) {
                for(Integer right : rights) {
                    switch(operators.get(i)) {
                        case '+' : result.add(left + right); break;
                        case '-' : result.add(left - right); break;
                        case '*' : result.add(left * right); break;
                        default: throw new RuntimeException();
                    }
                }
            }
        }


        cache[begin][end] = result;
        return result;
    }

    private static void parse(String input,List<Integer> operands,List<Character> operators) {
        int begin = 0;
        int index = 0;
        if (input.charAt(0) =='-') {
            index = 1;
        }
        for(int i = index; i < input.length();i++) {
            if (isDigit(input.charAt(i))) {
                continue;
            }
            operands.add(Integer.parseInt(input.substring(begin, i)));
            operators.add(input.charAt(i));
            begin = i+ 1;
        }
        if (input.length() > 0) {
            operands.add(Integer.parseInt(input.substring(begin, input.length())));
        }
    }
    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

}
