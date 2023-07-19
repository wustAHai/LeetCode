package easy;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenz at 9:10 on 2022/9/17 .
 */
public class L1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        char[] chars = s.toCharArray();
        int max = -1;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Integer integer = map.get(chars[i]);
            if (integer!=null){
                max=Math.max(max,i-integer-1);
            }else {
                map.put(chars[i],i);
            }
        }
        return max;
    }
}
