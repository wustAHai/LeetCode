package mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz at 17:35 on 2022/10/30 .
 */
public class L784 {
    public static void main(String[] args) {
        new L784().letterCasePermutation("a1b2");
    }
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        ans.add(s);
        for (int i = 0; i < s.length(); i++) {
            List<String> temp = new ArrayList<>();
            if (Character.isLetter(s.charAt(i))){
                for (String an : ans) {
                    char[] chars = an.toCharArray();
                    chars[i] = Character.toLowerCase(chars[i]);
                    temp.add(new String(chars));
                    chars[i] = Character.toUpperCase(chars[i]);
                    temp.add(new String(chars));
                }
                ans.clear();
                ans = temp;
            }
        }
        return ans;
    }
}
