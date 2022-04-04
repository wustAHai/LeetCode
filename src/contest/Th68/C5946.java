package contest.Th68;

/**
 * @author chenz at 0:35 on 2021/12/26 .
 */
public class C5946 {
    public int mostWordsFound(String[] sentences) {
        int ans = 0;
        for (String sentence : sentences) {
            int a = 0;
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i)==' '){
                    a++;
                }
            }
            if (a>0){
                a++;
            }
            ans = Math.max(ans,a);
        }
        return ans;
    }
}
