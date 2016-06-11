package util;

import java.util.Stack;

/**
 * Created by xzhou2 on 6/9/16.
 */
public class VerifyPreorderBT {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        String[] tokens = preorder.split(",");
        Stack<Boolean> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            boolean isLeaf = tokens[i].equals("#");
            if (!isLeaf) {
                stack.push(isLeaf);
            }
            else {
                if (stack.isEmpty() || !stack.peek()) {
                    stack.push(isLeaf);
                }
                else {
                    while(!stack.isEmpty() && stack.peek()) {
                        stack.pop();
                        if (stack.isEmpty() || stack.pop()) {
                            return false;
                        }
                    }
                    stack.push(isLeaf);
                }
            }
        }

        return stack.pop() && stack.isEmpty();
    }
}
