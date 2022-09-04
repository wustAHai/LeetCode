package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author chenz at 20:22 on 2022/9/1 .
 */
public class L1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Map<Integer,Integer> map1 = new HashMap<>();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer orDefault = map1.getOrDefault(entry.getValue(), 0);
            if (1==orDefault){
                return false;
            }
            map1.put(entry.getValue(),1);
        }
        return true;
    }
}
