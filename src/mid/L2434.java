package mid;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

/**
 * @author chenz at 22:52 on 2022/10/10 .
 */
public class L2434 {
    public String robotWithString(String s) {
        int[]cnt = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int idx = chars[i]-'a';
            cnt[idx]++;
        }
        int curMin = 0;
        curMin = findMin(curMin,cnt);
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int idx = ch-'a';
            stack.push(ch);
            cnt[idx]--;
            curMin = findMin(curMin,cnt);
            while (!stack.isEmpty()&&stack.peek()-'a'<=curMin){
                sb.append(stack.pop());
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    int findMin(int curMin,int[]cnt){
        for (int i = curMin; i < 26; i++) {
            if (cnt[i]>0){
                return i;
            }
        }
        return 26;
    }
}
