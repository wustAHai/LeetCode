package top500;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz at 22:08 on 2023/3/9 .
 */
public class T78子集 {
    public List<List<Integer>> subsets(int[] nums) {
        int n = 1<<nums.length;
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i <n; i++) {
            List<Integer> list = new ArrayList<>();
     /*       for (int j = 0; j < nums.length; j++) {
                if ((1<<j&i)>0){
                    list.add(nums[j]);
                }
            }*/
            int j = 0;
            int k =i;
            while (k>0){
                if((k&1)==1){
                    list.add(nums[j]);
                }
                j++;
                k>>=1;
            }
            ret.add(list);
        }
        return ret;
    }
}
