package contest.The305;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chenz at 10:23 on 2022/8/7 .
 */
public class Main {
    boolean[] visited;
    ArrayList<Integer>[] egs;
    int ans;

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.longestIdealString("acfgbd", 2));

    }

    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> restrict = new HashSet<>();
        for (int i : restricted) {
            restrict.add(i);
        }
        egs = new ArrayList[n];
        for (int i = 0; i < egs.length; i++) {
            egs[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            if (restrict.contains(edges[i][0]) || restrict.contains(edges[i][1])) {
                continue;
            }
            egs[edges[i][0]].add(edges[i][1]);
            egs[edges[i][1]].add(edges[i][0]);
        }
        visited = new boolean[n];
        dfs(0);
        return ans;
    }

    void dfs(int start) {
        if (visited[start]) {
            return;
        }
        ans++;
        visited[start] = true;
        ArrayList<Integer> eg = egs[0];
        for (Integer integer : eg) {
            dfs(integer);
        }
    }

    //0 0 0 1 1
    public boolean validPartition(int[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            nums[i] -= nums[i - 1];
        }
        boolean[] dp = new boolean[nums.length + 1];
        nums[0] = 0;
        dp[0] = true;
        dp[1] = false;
        if (nums[1] == 0) {
            dp[2] = true;
        }
        for (int i = 2; i < nums.length; i++) {
            dp[i + 1] = dp[i + 1 - 2] && (nums[i] == 0) || dp[i + 1 - 3] && ((nums[i] == 1 && nums[i - 1] == 1) || (nums[i] == 0 && nums[i - 1] == 0));
        }
        return dp[nums.length];
    }

    public int longestIdealString(String s, int k) {
        int ans = 0;
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - 'a';
            int l = 0;
            for (int j = Math.max(0, temp - k); j < 26 && j <= temp + k; j++) {
                if (cnt[j] + 1 > ans) {
                    ans = cnt[j] + 1;
                }
                l = Math.max(l, cnt[j] + 1);

            }
            cnt[temp] = Math.max(l, cnt[temp]);
        }
        return ans;
    }
}
