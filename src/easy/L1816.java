package easy;

/**
 * @author chenz at 21:39 on 2021/12/6 .
 */
public class L1816 {
    public String truncateSentence(String s, int k) {
        int n = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' '){
                if (++n == k){
                    return s.substring(0,i);
                }
            }
        }
        return s;
    }
}
