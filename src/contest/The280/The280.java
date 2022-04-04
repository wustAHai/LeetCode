package contest.The280;

import java.util.*;

/**
 * @author chenz at 10:32 on 2022/2/13 .
 */
public class The280 {
    public int countOperations(int num1, int num2) {
        int  ans = 0;
        while (num1!=0&&num2!=0){
            if (num1>=num2){
                num1-=num2;
            }else {
                num2-=num1;
            }
            ans++;
        }
        return ans;
    }

    public int minimumOperations(int[] nums) {
        if (nums.length==1){
            return 0;
        }
        Map<Integer,Integer> map0 = new HashMap<>();
        for (int i = 0; i < nums.length; i+=2) {
            map0.put(nums[i],map0.getOrDefault(nums[i],0)+1);
        }
        Map<Integer,Integer> map1 = new HashMap<>();
        for (int i = 1; i < nums.length ;i+=2) {
            map1.put(nums[i],map1.getOrDefault(nums[i],0)+1);
        }
        ArrayList<Map.Entry<Integer, Integer>> list0 = new ArrayList<>(map0.entrySet());
        ArrayList<Map.Entry<Integer, Integer>> list1 = new ArrayList<>(map1.entrySet());
        list0.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        list1.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        Map.Entry<Integer, Integer> e0 = list0.get(0);
        Map.Entry<Integer, Integer> e1 = list1.get(0);
        if (e0.getKey()!=e1.getKey()){
            return nums.length-e0.getValue()-e1.getValue();
        }else {
            if (list0.size()==1&&list1.size()==1){
                return nums.length/2;
            }else if (list0.size()>1&&list1.size()==1){
                int count0 = (nums.length+1)/2;
                int count1 = nums.length/2;
               return Math.min(count0-list0.get(1).getValue(),count0-list0.get(0).getValue()+count1);
            }else if (list0.size()==1){
                return nums.length-list1.get(1).getValue()-list0.get(0).getValue();
            }else {
                return nums.length-Math.max(list0.get(0).getValue()+list1.get(1).getValue(),list0.get(1).getValue()+list1.get(0).getValue());
            }
        }
    }

    public long minimumRemoval(int[] beans) {
        long sum =Long.MAX_VALUE;
        Arrays.sort(beans);
        long total=0;
        for (int i = 0; i < beans.length; i++) {
            total+=beans[i];
        }
        for (int i = 0; i < beans.length; i++) {
            if (i!=0&&beans[i-1]==beans[i]){
                continue;
            }
            sum = Math.min(sum,total-(long)beans[i]*(beans.length-i));
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,3,2,4,3};
        The280 the280 = new The280();
        the280.minimumOperations(arr);
    }
}
