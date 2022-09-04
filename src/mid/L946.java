package mid;

import java.util.Stack;

/**
 * @author chenz at 18:47 on 2022/8/31 .
 */
public class L946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        int n = pushed.length;
        while (i<n&&j<n){
            if(pushed[i]==popped[j]){
                i++;
                j++;
            }else {
                if (stack.isEmpty()){
                    stack.push(pushed[i++]);
                }else {
                    if (stack.peek()==popped[j]){
                        stack.pop();
                        j++;
                    }else {
                        stack.push(pushed[i++]);
                    }
                }
            }
        }
       while (j<n){
           if (stack.peek()==popped[j++]){
               stack.pop();
           }else {
               return false;
           }
       }
       return stack.isEmpty();
    }
}
