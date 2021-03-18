package easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by chenz at 11:18 on 2021/3/9
 */
public class L1047 {
    public String removeDuplicates(String S) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
           if (deque.peekLast()==null||deque.peekLast()!=S.charAt(i)){
               deque.addLast(S.charAt(i));
           }else {
               deque.removeLast();
           }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()){
            stringBuilder.append(deque.pop());
        }
        return stringBuilder.toString();
    }
}
