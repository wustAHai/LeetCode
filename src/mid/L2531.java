package mid;

/**
 * @author chenz at 20:02 on 2023/1/14 .
 */
public class L2531 {
    public boolean isItPossible(String word1, String word2) {
        int[] w1 = new int[26];
        int[] w2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            w1[word1.charAt(i)-'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            w2[word2.charAt(i)-'a']++;
        }

        for (int i = 0; i < w1.length; i++) {
            if (w1[i]==0){
                continue;
            }
            w1[i]--;
            for (int j = 0; j < w2.length; j++) {
                if (w2[j]==0){
                    continue;
                }
                w2[i]++;
                w2[j]--;
                w1[j]++;
                int sum1 =0;
                int sum2 =0;
                for (int i1 : w1) {
                    if (i1>0){
                        sum1++;
                    }
                }
                for (int i1 : w2) {
                    if (i1>0){
                        sum2++;
                    }
                }
                if (sum1 == sum2){
                    return true;
                }
                w2[i]--;
                w2[j]++;
                w1[j]--;
            }
            w1[i]++;
        }
        return false;
    }

}
