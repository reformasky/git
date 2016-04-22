package util;

import java.util.Stack;

/**
 * Created by xzhou2 on 4/21/16.
 */
class MyQueue {
    // Push element x to the back of queue.
    // Push element x to the back of queue.
    Stack<Integer> stack1 = new Stack<>(),
            stack2 = new Stack<>();

    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        helper();
        stack2.pop();
    }

    // Get the front element.
    public int peek() {
        helper();
        return stack2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void helper() {
        if (empty()) {
            throw new RuntimeException();
        }
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}