package easy;

/**
 * @author chenz at 1:37 on 2022/1/7 .
 */
public class L1614 {
    public int maxDepth(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int ans =  0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i]=='('){
                temp++;
                ans = Math.max(ans,temp);
            }
            if (chars[i]==')'){
                temp--;
            }
        }
        return ans;
    }
}
