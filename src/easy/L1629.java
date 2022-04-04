package easy;

/**
 * @author chenz at 9:18 on 2022/1/9 .
 */
public class L1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        long[] time = new long[26];
        long sTime = 0;
        for (int i = 0; i < releaseTimes.length; i++) {
            int index = keysPressed.charAt(i) - 'a';
            time[index]=Math.max(releaseTimes[i]-sTime,time[index]);
            sTime = releaseTimes[i];
        }
        long maxTime = 0;
        char ans = 'a';
        for (int i = 0; i < time.length; i++) {
            if (maxTime<=time[i]){
                ans = (char)('a'+i);
                maxTime = time[i];
            }
        }
        return ans;
    }
}
