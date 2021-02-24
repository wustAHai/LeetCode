package easy;


import java.util.Deque;
import java.util.LinkedList;

class MyStack {

    Deque<Integer> myStack;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        myStack = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        myStack.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return myStack.removeLast();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return myStack.getLast();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return myStack.isEmpty();
    }
}

public class L225 {

}
