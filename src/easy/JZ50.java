package easy;

/**
 * Created by chenz at 19:16 on 2021/2/13
 */
public class JZ50 {
    public char firstUniqChar(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (counts[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
