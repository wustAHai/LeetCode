package contest.L77;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

/**
 * @author chenz at 19:47 on 2022/5/2 .
 */
public class Solution {
    public int countPrefixes(String[] words, String s) {
        int ans = 0;
        for (String word : words) {
            if (s.startsWith(word)){
                ans++;
            }
        }
        return ans;
    }
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long sum = 0l;
        for (int num : nums) {
            sum += num;
        }
        int ans = n-1;
        long min = sum/nums.length;
        long presum = 0;
        for (int i = 0; i < nums.length-1; i++) {
            presum+=nums[i];
            long a = Math.abs(presum/(i+1) - (sum-presum)/(n-i-1));
            if (min>a){
                min=a;
                ans=i;
            }else if (min == a){
                ans = Math.min(i,ans);
            }
        }
        return ans;
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] box = new int[m][n];
        for (int[] guard : guards) {
            box[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            box[wall[0]][wall[1]]=2;
        }
        for (int[] guard : guards) {
            int i = guard[0];
            int j = guard[1];
            while (--j>=0&&(box[i][j]==0||box[i][j]==3)){
                box[i][j]=3;
            }
            j = guard[1];
            while (++j<n&&(box[i][j]==0||box[i][j]==3)){
                box[i][j]=3;
            }
            j=guard[1];
            while (--i>=0&&(box[i][j]==0||box[i][j]==3)){
                box[i][j]=3;
            }
            i=guard[0];
            while (++i<m&&(box[i][j]==0||box[i][j]==3)){
                box[i][j]=3;
            }
        }
        int ans =0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (box[i][j]==0){
                    ans++;
                }
            }
        }
        return ans;
    }



    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maximumMinutes(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int left = -1, right = m * n;
        while (left < right) {
            var mid = (left + right + 1 ) / 2;
            if (check(grid, mid)) left = mid;
            else right = mid - 1;
        }
        return left < m * n ? left : (int) 1e9;
    }

    boolean check(int[][] grid, int t) {
        int m = grid.length, n = grid[0].length;
        var fire = new boolean[m][n];
        var f = new ArrayList<int[]>();
        for (var i = 0; i < m; i++)
            for (var j = 0; j < n; j++)
                if (grid[i][j] == 1) {
                    fire[i][j] = true;
                    f.add(new int[]{i, j});
                }
        while (t-- > 0 && f.size() > 0)
            f = spreadFire(grid, fire, f); // 蔓延至多 t 分钟的火势
        if (fire[0][0]) return false; // 起点着火，寄

        var vis = new boolean[m][n];
        vis[0][0] = true;
        var q = new ArrayList<int[]>();
        q.add(new int[]{0, 0});
        while (q.size() > 0) {
            var tmp = q;
            q = new ArrayList<>();
            for (var p : tmp)
                if (!fire[p[0]][p[1]])
                    for (var d : dirs) {
                        int x = p[0] + d[0], y = p[1] + d[1];
                        if (0 <= x && x < m && 0 <= y && y < n && !fire[x][y] && !vis[x][y] && grid[x][y] != 2) {
                            if (x == m - 1 && y == n - 1) return true; // 我们安全了…暂时。
                            vis[x][y] = true;
                            q.add(new int[]{x, y});
                        }
                    }
            f = spreadFire(grid, fire, f); // 蔓延 1 分钟的火势
        }
        return false; // 寄
    }

    ArrayList<int[]> spreadFire(int[][] grid, boolean[][] fire, ArrayList<int[]> f) {
        int m = grid.length, n = grid[0].length;
        var tmp = f;
        f = new ArrayList<>();
        for (var p : tmp)
            for (var d : dirs) {
                int x = p[0] + d[0], y = p[1] + d[1];
                if (0 <= x && x < m && 0 <= y && y < n && !fire[x][y] && grid[x][y] != 2) {
                    fire[x][y] = true;
                    f.add(new int[]{x, y});
                }
            }
        return f;
    }


}
