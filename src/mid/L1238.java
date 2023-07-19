package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenz at 20:15 on 2023/2/23 .
 */
public class L1238 {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < n; i++) {
            int m = list.size();
            for (int j = m-1; j >=0 ; j--) {
                list.add(list.get(j)|(1<<(i)));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            list.set(i,list.get(i)^start);
        }
        return list;
    }
    public int[] leftRigthDifference(int[] nums) {
        int[] left = new int[nums.length];
        for (int i = 1; i < left.length; i++) {
            left[i]=left[i-1]+nums[i-1];
        }
        int[] right = new int[nums.length];
        for (int i = nums.length-2; i >=0 ; i--) {
            right[i]=right[i+1]+nums[i+1];
        }
        int[] ret = new int[nums.length];

        for (int i = 0; i < ret.length; i++) {
            ret[i]=Math.abs(right[i]-left[i]);
        }
        return ret;
    }


    public int[] divisibilityArray(String word, int m) {
        char[] chars = word.toCharArray();
        int[] ret = new int[chars.length];
        long left = 0;
        for (int i = 0; i < ret.length; i++) {
           long sum =  left*10 + chars[i]-'0';
            ret[i]= (int) (sum%m);
            left=ret[i];
        }
        for (int i = 0; i < ret.length; i++) {
            if (ret[i]!=0){
                ret[i]=0;
            }else {
                ret[i]=1;
            }
        }
        return ret;
    }

    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int n =nums.length/2;
        int i = n-1;
        int j = nums.length-1;
        int ans = 0;
        while (i>=0&&j>=n){
            if (nums[i]*2<=nums[j]){
                i--;
                j--;
                ans+=2;
            }else {
                i--;
            }
        }
        return ans;
    }
}
