package contest.The276;


import java.util.List;

/**
 * @author chenz at 10:18 on 2022/1/16 .
 */
public class S1 {
    public String[] divideString(String s, int k, char fill) {
        char[] chars = s.toCharArray();
        int l = chars.length/k;
        if (chars.length%k>0){
            l++;
        }
        String[] ans = new String[l];
        for (int i = 0; i < l-1; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = i*k; j < (i+1)*k; j++) {
                stringBuilder.append(chars[j]);
            }
            ans[i] = stringBuilder.toString();
        }
        int i = l-1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = i*k; j < chars.length; j++) {
            stringBuilder.append(chars[j]);
        }
        while (stringBuilder.length()<k){
            stringBuilder.append(fill);
        }
        ans[i] = stringBuilder.toString();
        return ans;
    }
}
