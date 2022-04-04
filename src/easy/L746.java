package easy;

public class L746 {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        if (length <= 1) {
            return 0;
        }
        if (length == 2) {
            return cost[0] > cost[1] ? cost[1] : cost[0];
        }
        int[] dp = new int[length];
        int p = 0;
        int q = 0;
        for (int i = 2; i < length; i++) {
            int next = Math.min(p + cost[i - 2], q + cost[i - 1]);
            p = q;
            q = next;
        }
        return Math.min(q + cost[length - 1], p + cost[length - 2]);
    }
}
