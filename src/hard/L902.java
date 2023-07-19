package hard;

/**
 * @author chenz at 20:43 on 2022/10/18 .
 */
public class L902 {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = Integer.toString(n);
        char[] chars = s.toCharArray();
        char[] dig = new char[digits.length];
        for (int i = 0; i < dig.length; i++) {
            dig[i] = digits[i].charAt(0);
        }
        int k = chars.length;
        int[][] dp = new int[k+1][0];
        dp[0][1] = 1;
        for (int i = 1; i <= k ; i++) {
            if (dp[i-1][1]==0){
                dp[i][1]=0;
            }else {
                boolean flag = false;
                for (char c : dig) {
                    if (c==chars[i-1]){
                        flag=true;
                        break;
                    }
                }
                if (flag){
                    dp[i][1]=1;
                }
            }
            if (i==1){
                dp[i][0]=func(dig,chars[i-1]);
            }else {
                dp[i][0]=dig.length+dp[i-1][0]*dig.length+dp[i-1][1]*func(dig,chars[i-1]);
            }
        }
        return dp[k+1][0]+dp[k+1][1];
    }

    private int func(char[] dig, char aChar) {
        int ans = 0;
        for (char c : dig) {
            if (c<aChar){
                ans++;
            }else {
                return ans;
            }
        }
        return ans;
    }

}
