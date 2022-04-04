package offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenz at 16:15 on 2021/12/21 .
 */
public class JZ30 {
    class MinStack {
        Deque<Integer> stack1;
        Deque<Integer> stack2;
        /** initialize your data structure here. */
        public MinStack() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void push(int x) {
            stack1.push(x);
            if (stack2.isEmpty()){
                stack2.push(x);
            }else {
                Integer peek = stack2.peek();
                if (x <= peek){
                    stack2.push(x);
                }
            }
        }

        public void pop() {
            int pop = stack1.pop();
            if (pop == stack2.peek()){
                stack2.pop();
            }
        }

        public int top() {
            return stack1.peek();
        }

        public int min() {
            return stack2.peek();
        }
    }
}
