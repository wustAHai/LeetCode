package easy;

import java.util.*;

/**
 * @author chenz at 21:15 on 2022/9/19 .
 */
public class L1636 {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> arr = new ArrayList<>(nums.length);
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
            arr.add(num);
        }
        arr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int c = map.get(a)-map.get(b);
                return c !=0?c:a.compareTo(b);
            }
        });
        for (int i = 0; i < arr.size(); i++) {
            nums[i]=arr.get(i);
        }
        return nums;
    }
}
