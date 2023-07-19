package mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenz at 22:05 on 2022/10/5 .
 */
public class L811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] s = cpdomain.split(" ");
            int i = Integer.parseInt(s[0]);
            char[] chars = s[1].toCharArray();
            map.put(s[1],map.getOrDefault(s[1],0)+i);
            for (int j = 0; j < chars.length; j++) {
                if (chars[j]=='.'){
                    String substring = s[1].substring(j + 1);
                    map.put(substring,map.getOrDefault(substring,0)+i);
                }
            }
        }
        List<String> ans = new ArrayList<>(map.size());
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            ans.add(stringIntegerEntry.getValue()+" "+stringIntegerEntry.getKey());
        }
        return ans;
    }
}
