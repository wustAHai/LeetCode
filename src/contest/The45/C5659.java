package contest.The45;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chenz at 22:49 on 2021/2/6
 */
public class C5659 {
    //equals break 不能忘
    public int minimumLength(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            deque.addLast(s.charAt(i));
        }

        while (deque.size() > 1) {
            if (!deque.peekFirst().equals(deque.peekLast())) {
                break;
            }
            Character character = deque.peek();
            while (!deque.isEmpty()) {
                if (deque.peekFirst().equals(character)) {
                    deque.removeFirst();
                } else {
                    break;
                }
            }
            while (!deque.isEmpty()) {
                if (deque.peekLast().equals(character)) {
                    deque.removeLast();
                } else {
                    break;
                }
            }
            //System.out.println(deque);
        }
        return deque.size();
    }

    @Test
    public void test() {
        System.out.println(minimumLength("aabccabba"));
    }
}
