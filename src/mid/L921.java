package mid;

import java.util.Stack;

/**
 * @author chenz at 22:09 on 2022/10/4 .
 */
public class L921 {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()){
                stack.push(ch);
            }else if (stack.peek()=='(' && ch==')'){
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        return stack.size();
    }
}
