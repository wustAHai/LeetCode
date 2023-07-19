package mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz at 20:25 on 2022/10/15 .
 */
public class L1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < target.length; i++) {
            while (num<target[i]){
                num++;
                list.add("Push");
                list.add("Pop");
            }
            list.add("Push");
            num++;
        }
        return list;
    }
}
