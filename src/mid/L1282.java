package mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenz at 18:26 on 2022/8/12 .
 */
public class L1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> orDefault = map.getOrDefault(groupSizes[i], new ArrayList<>());
            orDefault.add(i);
            if (orDefault.size()==groupSizes[i]){
                map.remove(groupSizes[i]);
                ans.add(orDefault);
            }else {
                map.put(groupSizes[i],orDefault);
            }
        }
        return ans;
    }
}
