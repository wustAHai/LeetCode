package mid;

import java.util.Stack;

/**
 * @author chenz at 21:23 on 2023/2/14 .
 */
public class L1124 {
    public int longestWPI(int[] hours) {
        int[] s = new int[hours.length+1];
        for (int i = 0; i < hours.length; i++) {
            if (hours[i]>8){
                hours[i]=1;
            }else {
                hours[i]=-1;
            }
            s[i+1]=s[i]+hours[i];
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            if (stack.isEmpty()){
                stack.push(i);
            }else if (s[stack.peek()]>s[i]){
                stack.push(i);
            }
        }
        int res = 0;
        for (int i = s.length-1; i >=0 ; i--) {
            while (!stack.isEmpty() &&s[i]-s[stack.peek()]>0){
                Integer pop = stack.pop();
                res = Math.max(res,i-pop);
            }
            if (stack.isEmpty()){
                break;
            }
        }
        return res;
    }
}
