package mid;

/**
 * @author chenz at 18:58 on 2022/3/29 .
 */
@SuppressWarnings("all")
public class L2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        if(k>=answerKey.length()){
            return answerKey.length();
        }
        char ch = 'T';
        int max = 0;
        for (int l = 0,r=0,yong=0; r < answerKey.length(); r++) {
            if (answerKey.charAt(r)==ch){
                yong++;
            }
            while (yong>k){
                if (answerKey.charAt(l)==ch){
                    yong--;
                    l++;
                }
            }
            max = Math.max(max,r-l+1);
        }
        ch = 'F';
        for (int l = 0,r=0,yong=0; r < answerKey.length(); r++) {
            if (answerKey.charAt(r)==ch){
                yong++;
            }
            while (yong>k){
                if (answerKey.charAt(l)==ch){
                    yong--;
                    l++;
                }
            }
            max = Math.max(max,r-l+1);
        }
        return max;
    }
}
