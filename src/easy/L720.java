package easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * @author chenz at 19:02 on 2022/3/17 .
 */
public class L720 {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a,b)->a.length()!=b.length()?a.length()-b.length():b.compareTo(a));
        HashSet<String> strings = new HashSet<>();
        String ans = "";
        strings.add(ans);
        for (String word : words) {
            if (strings.contains(word.substring(0,word.length()-1))){
                ans = word;
                strings.add(ans);
            }
        }
        return ans;
    }
}
