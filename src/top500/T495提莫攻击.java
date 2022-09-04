package top500;

/**
 * @author chenz at 21:08 on 2022/7/13 .
 */
public class T495提莫攻击 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans =duration;
        for (int i = 1; i < timeSeries.length; i++) {
            ans+=Math.min(duration,timeSeries[i]-timeSeries[i-1]);
        }
        return ans;
    }
}
