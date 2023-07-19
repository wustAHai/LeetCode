package easy;

import java.util.*;

/**
 * @author chenz at 22:25 on 2022/10/5 .
 */
public class L2423 {

    public boolean equalFrequency(String word) {
        char[] chars = word.toCharArray();
        int[]ints = new  int[26];
        for (char aChar : chars) {
             ints[aChar - 'a']++;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i]==0){
                continue;
            }
            ints[i]--;
            if (valid(ints)){
                return true;
            }
            ints[i]++;
        }
        return false;
    }

    private boolean valid(int[] ints) {
        int t = 0 ;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i]==0){
                continue;
            }
            if (t!=0&&t!=ints[i]){
                return false;
            }
            t=ints[i];
        }
        return true;
    }
}
