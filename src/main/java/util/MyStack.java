package util;

import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.Queue;

/**
 * Created by xzhou2 on 4/21/16.
 */
public class MyStack {
    // Push element x onto stack.
    Queue<Integer> queue1 = new ArrayDeque<>(),
            queue2 = new ArrayDeque<>();

    public void push(int x) {
        if (queue2.isEmpty()) {
            queue1.add(x);
        }
        else {
            queue2.add(x);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (empty()) {
            throw new RuntimeException();
        }
        Queue source, target;
        if (queue1.isEmpty()) {
            source = queue2;
            target = queue1;
        }
        else {
            source = queue1;
            target = queue2;
        }

        while(source.size() > 1) {
            target.add(source.remove());
        }
        source.remove();
    }

    // Get the top element.
    public int top() {
        if (empty()) {
            throw new RuntimeException();
        }
        Queue source, target;
        if (queue1.isEmpty()) {
            source = queue2;
            target = queue1;
        }
        else {
            source = queue1;
            target = queue2;
        }

        while(source.size() > 1) {
            target.add(source.remove());
        }
        int result =(Integer)source.remove();
        target.add(result);
        return result;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
