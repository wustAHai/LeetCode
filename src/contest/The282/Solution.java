package contest.The282;

/**
 * @author chenz at 10:36 on 2022/2/27 .
 */
public class Solution {
    public int prefixCount(String[] words, String pref) {
        int i = 0;
        for (String word : words) {
            if (word.startsWith(pref)){
                i++;
            }
        }
        return i;
    }

    public int minSteps(String s, String t) {
        int[] chs = new int[26];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            chs[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            chs[t.charAt(i)-'a']--;
        }
        for (int ch : chs) {
            ans += Math.abs(ch);
        }
        return ans;
    }

    public long minimumTime(int[] time, int totalTrips) {
        long min = time[0];
        for (int i = 1; i < time.length; i++) {
            if (min>time[i]){
                min = time[i];
            }
        }
        long high = totalTrips*min;
        long low  = 1;
        while (low<high){
            long mid = low+(high-low)/2;
            long temp = 0;
            for (int i : time) {
                temp+=mid/i;
            }
            if (temp>=totalTrips){
                high = mid;
            }else {
                low = mid+1;
            }
        }
        return low;
    }
}
