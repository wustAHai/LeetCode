package easy;

import java.util.*;
import java.util.function.Consumer;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author chenz at 0:04 on 2022/4/17 .
 */
public class L819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        String pattern = "\\w+";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(paragraph);
        HashSet<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String,Integer> map = new HashMap<>();
        int max = 0;
        String s = null;
        while (matcher.find()){
            String group = matcher.group().toLowerCase(Locale.ROOT);
            if (set.contains(group)){
                continue;
            }
            int a =map.getOrDefault(group,0)+1;
            map.put(group,a);
            if (a>max){
                max = a;
                s=group;
            }
        }
        return s;
    }
    
}
