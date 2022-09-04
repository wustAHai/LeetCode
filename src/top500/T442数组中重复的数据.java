package top500;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz at 13:21 on 2022/5/8 .
 */
public class T442数组中重复的数据 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i]);
            if (nums[x-1]>0){
                nums[x-1]=-nums[x-1];
            }else {
                ans.add(x);
            }
        }
        return ans;
    }



}
