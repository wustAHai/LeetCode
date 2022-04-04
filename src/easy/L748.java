package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenz at 12:46 on 2021/12/10 .
 */
public class L748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = new int[26];
        for (int i = 0; i < licensePlate.length(); i++) {
            char ch = licensePlate.charAt(i);
            if ('a'<=ch&&ch<='z'||'A'<=ch&&ch<='Z'){
               count[Character.toLowerCase(ch)-'a']++;
            }
        }
        String ans = null;
        for (int i = 0; i < words.length; i++) {
            int[] tempCount = new int[26];
            String temp = words[i];
            boolean match = true;
            for (int j = 0; j < temp.length(); j++) {
                char ch = temp.charAt(j);
                if ('a'<=ch&&ch<='z'||'A'<=ch&&ch<='Z'){
                    tempCount[Character.toLowerCase(ch)-'a']++;
                }
            }
            for (int j = 0; j < 26; j++) {
                if (tempCount[j]<count[j]){
                    match = false;
                    break;
                }
            }
            if (match){
                if (ans == null){
                    ans = temp;
                }else if (temp.length()<ans.length()){
                    ans = temp;
                }
            }

        }
        return ans;
    }
}
