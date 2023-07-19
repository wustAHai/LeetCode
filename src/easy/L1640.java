package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenz at 23:38 on 2022/9/22 .
 */
public class L1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                map.put(pieces[i][j],i);
            }
        }
        for (int i = 0; i < arr.length; ) {
            Integer integer = map.get(arr[i]);
            for (int j=0; j < pieces[integer].length; j++,i++) {
                if (pieces[integer][j]!=arr[i]){
                    return false;
                }
            }
        }
        return true;
    }
}
