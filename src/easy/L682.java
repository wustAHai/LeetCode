package easy;

import java.util.Stack;

/**
 * Created by chenz at 7:29 on 2021/3/5
 */
public class L682 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if ("+".equals(op)){
                int a = stack.pop();
                int b = stack.peek();
                stack.push(a);
                stack.push(a+b);
            }else if ("D".equals(op)){
                stack.push(stack.peek()*2);
            }else if ("C".equals(op)){
                stack.pop();
            }else {
                stack.push(Integer.valueOf(op));
            }
        }
        int ans = 0;
        while (!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }

    public int calPoints0(String[] ops) {
        Stack<Integer> integers = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            if ("C".equals(ops[i])){
                integers.pop();
            }else if ("D".equals(ops[i])){
                integers.push(integers.peek()*2);
            }else if ("+".equals(ops[i])){
                int b = integers.pop();
                int a = integers.peek();
                integers.push(b);
                integers.push(a+b);
            }else {
                integers.push(Integer.parseInt(ops[i]));
            }
        }
        int sum=0;
        while (integers.size()>0){
            sum+=integers.pop();
        }
        return sum;
    }
}
