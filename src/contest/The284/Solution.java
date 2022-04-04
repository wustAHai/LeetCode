package contest.The284;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz at 10:33 on 2022/3/13 .
 */
public class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
       List<Integer> list = new ArrayList<>();
       int q = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==key){
                int index = Math.max(q+1,i-k);
                while (index<nums.length&&index<=i+k){
                    q=index;
                    list.add(index);
                    index++;
                }
            }
        }
        return list;
    }

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int  ans = 0 ;
        boolean[][] visit = new boolean[n][n];
        for (int i = 0; i <dig.length; i++) {
            visit[dig[i][0]][dig[i][1]] = true;
        }
        for (int[] artifact : artifacts) {
           int r1 = artifact[0];
           int c1 = artifact[1];
           int r2 = artifact[2];
           int c2 = artifact[3];
           boolean flag = true;
            for (int i = r1; i <=r2; i++) {
                for (int j = c1; j <= c2; j++) {
                    if (!visit[i][j]) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag){
                ans++;
            }
        }
        return ans;
    }

    //
 /*   public int maximumTop(int[] nums, int k) {
    }*/
}
