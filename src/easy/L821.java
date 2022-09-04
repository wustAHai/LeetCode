package easy;

/**
 * @author chenz at 19:53 on 2022/4/19 .
 */
public class L821 {
    public int[] shortestToChar(String s, char c) {
        int left = -1;
        int right = -1;
        int n = s.length();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                left = i;
            } else {
                if (right < i) {
                    right = i + 1;
                    for (; right < n; right++) {
                        if (s.charAt(right) == c) {
                            break;
                        }
                    }
                }
                if (right == n) {
                    ans[i] = i - left;
                }else {
                    if (left<0){
                        ans[i]=right-i;
                    }else {
                        ans[i] = Math.min(i-left,right-i);
                    }
                }
            }
        }
        return ans;
    }
}