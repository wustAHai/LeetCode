package easy;

/**
 * @author chenz at 20:22 on 2022/10/9 .
 */
public class L6200 {
    public int hardestWorker(int n, int[][] logs) {
        int ans = logs[0][0];
        int max=  logs[0][1];
        for (int i = 1; i < logs.length; i++) {
            int time = logs[i][1]-logs[i-1][1];
            if (time>max){
                max = time;
                ans = logs[i][0];
            }else if (time == max){
                ans = Math.min(ans,logs[i][0]);
            }
        }
        return ans;
    }
}
