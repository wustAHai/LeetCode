package mid;

import java.util.Stack;

/**
 * @author chenz at 20:28 on 2022/7/13 .
 */
public class L735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (stack.isEmpty()||stack.peek()<0||asteroid>0){
                stack.push(asteroid);
                continue;
            }
            boolean add = true;
            while (!stack.isEmpty()&&stack.peek()>0){
                Integer peek = stack.peek();
                add = true;
                if (peek>Math.abs(asteroid)) {
                    add = false;
                    break;
                }else if (peek == Math.abs(asteroid)){
                    add = false;
                    stack.pop();
                    break;
                }else {
                    stack.pop();
                }
            }
            if (add){
                stack.push(asteroid);
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = stack.size()-1; i >= 0 ; i--) {
            ans[i]  = stack.pop();
        }
        return ans;
    }
}
