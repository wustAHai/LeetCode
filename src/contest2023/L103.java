package contest2023;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @author chenz at 22:29 on 2023/4/29 .
 */
public class L103 {
    public int maximizeSum(int[] nums, int k) {
        int asInt = 0;
        for (int i = 0; i < nums.length; i++) {
            asInt = Math.max(asInt,nums[i]);
        }
        return  asInt*k+k*(k-1)/2;
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ret = new  int[A.length];
        boolean[] has = new  boolean[51];
        for (int i = 0; i < A.length; i++) {
            has[A[i]]=true;
            int cnt = 0;
            for (int j = 0; j <=i ; j++) {
                if (has[B[j]]){
                    cnt++;
                }
            }
            ret[i] =cnt;
        }
        return ret;
    }

    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int m = 0;
    int n = 0;
    int[][] grid;
    boolean[][] visited;
    public int findMaxFish(int[][] grid) {
        int max = 0;
         m = grid.length;;
         n = grid[0].length;
         this.grid =grid;
         visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(dfs(0,i,j),max);
            }
        }
        return  max;
    }
    int dfs(int cnt,int i,int j){
        if (i<0||i>=m||j<0||j>=n||grid[i][j]==0||visited[i][j]){
            return cnt;
        }else {
            cnt+=grid[i][j];
            visited[i][j]=true;
        }
        for (int k = 0; k < dir.length; k++) {
           cnt = dfs(cnt,i+dir[k][0],j+dir[k][1]);
        }
        return cnt;
    }

    public long countOperationsToEmptyArray(int[] nums) {
        long ret = nums.length;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j]>nums[i]){
                    ret++;
                }
            }
        }
        return ret;
    }
}
