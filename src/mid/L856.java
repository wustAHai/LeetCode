package mid;

import java.util.Stack;

/**
 * @author chenz at 19:54 on 2022/10/9 .
 */
public class L856 {
    public int scoreOfParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        char[] chs  = s.toCharArray();
        boolean flag = false;
        for (char ch : chs) {
            if ('('==ch){
                stack.push(ch);
                flag=true;
            }else {
                stack.pop();
                if (flag){
                    ans+=1<<stack.size();
                }
                flag =false;
            }
        }
        return ans;
    }
}
