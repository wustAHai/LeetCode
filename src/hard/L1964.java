package hard;

public class L1964 {
    //超时
    public int[] longestObstacleCourseAtEachPosition0(int[] obstacles) {
        int[] ints = new int[obstacles.length];
        ints[0] = 1 ;
        for (int i = 1; i < obstacles.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (obstacles[j]<=obstacles[i]){
                    max = Math.max(max,ints[j]);
                }
            }
            ints[i] = max +1;
        }
        return ints;
    }
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] ans = new int[obstacles.length];
        ans[0] = 1;
        int len = 1;
        int[] dp = new int[obstacles.length +1];
        dp[1] = obstacles[0];
        for (int i=1;i< obstacles.length;i++){
            if (obstacles[i]>=dp[len]){
                ans[i] = ++len;
                dp[len] = obstacles[i];
            }else {
                int l = 1;
                int r = len;
                int pos =  0;
                while (l<=r){
                    int mid = (l+r)/2;
                    if (dp[mid]<=obstacles[i]){
                        l=mid+1;
                        pos = mid;
                    }else {
                        r=mid-1;
                    }
                }
                dp[pos+1] = obstacles[i];
                ans[i] = pos+1;
            }
        }
        return ans;
    }
}
