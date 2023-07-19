package mid;

/**
 * @author chenz at 19:38 on 2023/2/13 .
 */
public class L1234 {
    public int balancedString(String s) {
        int[] cnt = new int[26];
        int length = s.length();
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)-'A']++;
        }
        int avg = length/4;
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i]>avg){
                sum+=cnt[i]-avg;
            }
        }
        return sum;
    }
}
