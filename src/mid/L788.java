package mid;

/**
 * @author chenz at 8:54 on 2022/9/25 .
 */
public class L788 {
    public int rotatedDigits(int n) {
        //2 5 6 9    // 0 1 8  // 3 4 7
        int ans = 0;
        for(int i = 1;i<=n;i++){
            String s = i+"";
            if(s.contains("3")||s.contains("4")||s.contains("7")){
                continue;
            }
            if (s.contains("2")||s.contains("5")||s.contains("6")||s.contains("9")){
                ans++;
            }
        }
        return ans;
    }
}
