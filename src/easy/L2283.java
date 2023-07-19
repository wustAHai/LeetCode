package easy;

/**
 * @author chenz at 22:46 on 2022/10/13 .
 */
public class L2283 {
    public boolean digitCount(String num) {
        int[] cnt = new int[10];
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            cnt[chars[i]-'0']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (cnt[i]!=chars[i]-'0'){
                return false;
            }
        }
        return true;
    }
}
