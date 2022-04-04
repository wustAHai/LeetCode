package contest.the72;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz at 22:29 on 2022/2/19 .
 */
public class Solution {
    public int countPairs(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]==nums[j]&&i*j%k==0){
                    ans++;
                }
            }
        }
        return ans;
    }

    public long[] sumOfThree(long num) {
        if (num%3==0){
            long ans = num/3;
            return new  long[]{ans-1,ans,ans+1};
        }else {
            return new long[0];
        }
    }

    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();
        if ((finalSum&1)==1){
            return ans;
        }
        long num = 2l;
        while (finalSum/2>num){
                ans.add(num);
                finalSum-=num;
            num+=2;
        }
        if (finalSum>0){
            ans.add(finalSum);
        }
        return ans;
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int[] aux = new int[nums1.length];
        long ans = 0;
        for (int i = 0; i < nums1.length; i++) {
            aux[nums1[i]]=i;
        }
        int [] da = new int[nums1.length];
        for (int i = 1; i <nums1.length-1 ; i++) {
            for (int j = i+1; j < nums1.length; j++) {
                if (aux[nums2[i]]<aux[nums2[j]]){
                    da[i]++;
                }
            }
        }
        for (int i = 1; i < nums2.length-1; i++) {
            ans += (long) da[i] *(aux[nums2[i]]-(nums2.length-i-1-da[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i&(-i));
        }
    }
}
