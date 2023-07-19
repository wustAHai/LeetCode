package easy;

import java.util.Arrays;

/**
 * @author chenz at 23:29 on 2022/10/11 .
 */
public class L1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int diff = 0;
        int diff1 = -1;
        int diff2 = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i)!=s2.charAt(i)){
                diff++;
                if (diff==1){
                    diff1=i;
                }else if (diff==2){
                    diff2=i;
                }else {
                    return false;
                }
            }
        }
        if (diff==0){
            return true;
        }
        if (diff==2){
            if (s1.charAt(diff1)==s2.charAt(diff2)&&s1.charAt(diff2)==s2.charAt(diff1)){
                return true;
            }
        }
        return false;
    }
}
