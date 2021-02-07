package easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chenz at 14:29 on 2021/1/18
 */
public class L482 {
    public String licenseKeyFormatting(String S, int K) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i <S.length() ; i--) {
            char ch= S.charAt(i);
            if (Character.isDigit(ch)){
                deque.push(ch);
            }else if (Character.isUpperCase(ch)){
                deque.push(ch);
            }else if (Character.isLowerCase(ch)){
                deque.push(Character.toUpperCase(ch));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (deque.size()>K){
            for (int i = 0; i < K; i++) {
                stringBuilder.insert(0,deque.pop());
            }
            if (!deque.isEmpty()){
                stringBuilder.insert(0,'-');
            }
        }
        while (!deque.isEmpty()){
            stringBuilder.insert(0,deque.pop());
        }
        return stringBuilder.toString();
    }
}
