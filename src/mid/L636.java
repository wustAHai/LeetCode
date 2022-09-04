package mid;

import java.util.List;
import java.util.Stack;

/**
 * @author chenz at 17:48 on 2022/8/7 .
 */
public class L636 {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        int time = 0;
        for (int i = 0; i < logs.size(); i++) {
            String log = logs.get(i);
            String[] split = log.split(":");
            int func = Integer.parseInt(split[0]);
            ans[func]++;
            int timeStamp = Integer.parseInt(split[2]);
            if (time <= timeStamp&&!stack.isEmpty()) {
                ans[stack.peek()] += timeStamp - time-1;
                time = timeStamp;
            }
            if ("start".equals(split[1])) {
                stack.push(func);
            } else {
                stack.pop();
            }

        }
        return ans;
    }

}
