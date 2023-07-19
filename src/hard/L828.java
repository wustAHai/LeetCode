package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenz at 19:48 on 2022/9/6 .
 */
public class L828 {
    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)){
                List<Integer> list = new ArrayList<>();
                list.add(-1);
                map.put(ch,list);
            }
            map.get(ch).add(i);
        }
        int ans = 0;
        for (List<Integer> value : map.values()) {
            value.add(s.length());
            for (int i = 1; i < value.size()-1; i++) {
                ans+=(value.get(i)-value.get(i-1))*(value.get(i+1)-value.get(i));
            }
        }
        return ans;
    }
}
