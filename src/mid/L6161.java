package mid;

import java.util.Stack;

/**
 * @author chenz at 14:25 on 2022/8/28 .
 */
public class L6161 {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar=='*'){
                stack.pop();
            }else {
                stack.push(aChar);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
       return sb.reverse().toString();
    }
}
