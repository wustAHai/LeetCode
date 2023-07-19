package hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenz at 20:29 on 2022/10/26 .
 */
public class L862 {
    public int shortestSubarray(int[] nums, int k) {
        int[] preSum = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1] = preSum[i]+nums[i];
        }
        int ans = preSum.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < preSum.length; i++) {
            while (!deque.isEmpty()&&preSum[i]-preSum[deque.peekFirst()]>=k){
                ans = Math.min(ans,i-deque.pollFirst());
            }
            while (!deque.isEmpty()&&preSum[deque.peekLast()]>=preSum[i]){
                deque.pollLast();
            }
            deque.offer(i);
        }
        return ans== preSum.length?-1:ans;
    }
}
