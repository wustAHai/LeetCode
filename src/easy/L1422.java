package easy;

/**
 * @author chenz at 20:06 on 2022/8/14 .
 */
public class L1422 {
    public int maxScore(String s) {
        int num1=0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if ('0'!=aChar){
                num1++;
            }
        }
        int n0=0;
        int n1=0;
        int max=0;
        for (int i = 0; i < chars.length-1; i++) {
            if (chars[i]=='0'){
                n0++;
            }else {
                n1++;
            }
            max = Math.max(max,n0+num1-n1);
        }
        return max;
    }
}
