package hard;

import java.util.Arrays;

/**
 * @author chenz at 15:39 on 2022/10/22 .
 */
public class L1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i][0]=startTime[i];
            jobs[i][1]=endTime[i];
            jobs[i][2]=profit[i];
        }
        Arrays.sort(jobs,(a,b)->a[1]-b[1]);
        int[]dp = new int[startTime.length+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i]=Math.max(dp[i-1],dp[biSearch(jobs,i-1,jobs[i-1][0])]+jobs[i-1][2]);
        }
        return dp[startTime.length];
    }

    private int biSearch(int[][]jobs,int r, int t) {
        int l = 0;
        int mid =0;
        while (l<r) {
            mid = l+(r-l)>>1;
            if (jobs[mid][1]>t){
                r=mid;
            }else {
                l=mid+1;
            }
        }
        return l;
    }
}
