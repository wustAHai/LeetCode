package easy;

import java.util.*;

/**
 * @author chenz at 7:46 on 2022/1/30 .
 */
public class L884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] s = s1.split(" ");
        String[] s3 = s2.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String s4 : s) {
            map.put(s4, map.getOrDefault(s4,0)+1);
        }
        for (String s4 : s3) {
            map.put(s4, map.getOrDefault(s4,0)+1);
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        List<String> arr = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value==1){
                arr.add(key);
            }
        }
        return arr.toArray(new String[arr.size()]);
    }
}
