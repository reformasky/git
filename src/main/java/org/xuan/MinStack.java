package org.xuan;

import java.util.Stack;

/**
 * Created by xzhou2 on 4/3/16.
 */
public class MinStack {
    private Stack<Integer> value;
    private Stack<Integer> min;

    public MinStack() {
        this.value = new Stack<>();
        this.min = new Stack<>();
    }
    public void push(int x) {
        value.push(x);
        if (!min.isEmpty()) {
            min.push(Math.min(x, min.peek()));
        }
        else {
            min.push(x);
        }
    }

    public void pop() {
        value.pop();
        min.pop();
    }

    public int top() {
        if (value.isEmpty()) {
            throw new RuntimeException();
        }
        return value.peek();
    }

    public int getMin() {
        if (min.isEmpty()) {
            throw new RuntimeException();
        }
        return min.peek();
    }
}
