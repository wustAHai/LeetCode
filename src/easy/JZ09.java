package easy;

import java.util.Stack;


/**
 * Created by chenz at 22:53 on 2021/2/2
 */
public class JZ09 {
    class CQueue {
        Stack<Integer> a;
        Stack<Integer> b;

        public CQueue() {
            a = new Stack<>();
            b = new Stack<>();
        }

        public void appendTail(int value) {
            a.push(value);
        }

        public int deleteHead() {
            /*
            if (a.isEmpty()){
                return -1;
            }
            while (!a.isEmpty()){
                b.push(a.pop());
            }
            int res = b.pop();
            while (!b.isEmpty()){
                a.push(b.pop());
            }
            return res;
            */
            if (a.isEmpty() && b.isEmpty()) {
                return -1;
            }
            if (b.isEmpty()) {
                while (!a.isEmpty()) {
                    b.push(a.pop());
                }
            }
            return b.pop();
        }

    }
}
