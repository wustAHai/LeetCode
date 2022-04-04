package mid;

import java.util.Arrays;

/**
 * Created by chenz at 8:42 on 2021/2/10
 */
public class L567 {
    public boolean checkInclusion0(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 'a']++;
        }
        int[] temp = new int[26];
        for (int i = 0; i < s1.length() - 1; i++) {
            temp[s2.charAt(i) - 'a']++;
        }
        int p = 0;
        int q = s1.length() - 1;
        while (q < s2.length()) {
            temp[s2.charAt(q) - 'a']++;
            if (Arrays.equals(chars, temp)) {
                return true;
            }
            q++;
            temp[s2.charAt(p) - 'a']--;
            p++;
        }
        return false;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length()){
            return false;
        }
        int[] chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i)-'a']++;
        }
        int p=0;
        int q=0;
        for (; q < s1.length()-1; q++) {
            chars[s2.charAt(q)-'a']--;
        }
        while (q<s2.length()){
            chars[s2.charAt(q)-'a']--;
            if (flag(chars)){
                return true;
            }else {
                q++;
                chars[s2.charAt(p)-'a']++;
                p++;
            }
        }
        return false;
    }

    private boolean flag(int[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]!=0){
                return false;
            }
        }
        return true;
    }
}
