package top500;

import java.util.HashSet;
import java.util.List;

/**
 * @author chenz at 14:10 on 2022/3/23 .
 */
public class T139单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        HashSet<String> set  = new HashSet<>(wordDict);
        //dp[i]  = d[j] && contains[i]
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[i]){
                    break;
                }
                dp[i] = dp[j]&&set.contains(s.substring(j,i));
            }
        }
        return dp[s.length()];
    }

}
