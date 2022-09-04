package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenz at 11:04 on 2022/7/16 .
 */
public class L771 {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character,Integer> map = new HashMap<>();
        int ans  = 0;
        for (int i = 0; i < stones.length(); i++) {
            map.put(stones.charAt(i),map.getOrDefault(stones.charAt(i),0)+1);
        }
        for (int i = 0; i < jewels.length(); i++) {
            ans+=map.getOrDefault(jewels.charAt(i),0);
        }
        return ans;
    }
}
