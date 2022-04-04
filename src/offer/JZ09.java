package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenz at 15:40 on 2021/12/21 .
 */
public class JZ09 {
    class CQueue {
        Deque<Integer> stack1;
        Deque<Integer> stack2;
        public CQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()){
                if (stack1.isEmpty()){
                    return -1;
                }else {
                    while (!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                }
            }
            return stack2.pop();
        }
    }
}
