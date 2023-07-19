package contest.Th84;

import java.util.*;

/**
 * @author chenz at 22:30 on 2022/8/6 .
 */
public class Main {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ans =new ArrayList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int[] ints : items1) {
            map.put(ints[0],ints[1]);
        }
        for (int[] ints : items2) {
            map.put(ints[0],ints[1]+map.getOrDefault(ints[0],0));
        }
        for (Integer integer : map.navigableKeySet()) {
            List<Integer> list = new ArrayList<>();
            list.add(integer);
            list.add(map.get(integer));
            ans.add(list);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {

        }
        return ans;
    }

    public long countBadPairs(int[] nums) {
        long len = nums.length;
        long ans = len*(len-1)/2;
        for (int i = 0; i < nums.length; i++) {
            nums[i]=nums[i]-i;
        }
        Map<Integer,Long> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0l)+1);
        }
        for (Long value : map.values()) {
            ans-=value*(value-1)/2;
        }
        return ans;
    }
    public long taskSchedulerII(int[] tasks, int space) {
        long ans = 0;
        Map<Integer,Long> history = new HashMap<>();
        for (int task : tasks) {
            ans++;
            if (history.getOrDefault(task,(long) -space)+space>=ans){
                ans=history.get(task)+space+1;
            }
            history.put(task,ans);
        }
        return ans;
    }
    public long minimumReplacement(int[] nums) {
        long ans = 0;
        int preMax = nums[nums.length-1];
        for (int i = nums.length-2; i >=0 ; i--) {
            if (nums[i]<=preMax){
                preMax=nums[i];
            }else {
               int temp = (preMax+nums[i]-1)/nums[i];
                ans+= temp-1;
                preMax= preMax/temp;
            }
        }
        return ans;
    }
}
