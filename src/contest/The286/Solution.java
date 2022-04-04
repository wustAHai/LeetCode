package contest.The286;

import java.util.*;

/**
 * @author chenz at 10:11 on 2022/3/27 .
 */
public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        List<List<Integer>> ans = new ArrayList<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        ans.add(list1);
        ans.add(list2);
        for (Integer integer : set1) {
            if (!set2.contains(integer)){
                list1.add(integer);
            }
        }
        for (Integer integer : set2) {
            if (!set1.contains(integer)){
                list2.add(integer);
            }
        }
        return ans;
    }

    public int minDeletion(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length;) {
            int j = i+1;
            while (j<nums.length){
                if (nums[i]==nums[j]){
                    j++;
                }else {
                    break;
                }
            }
            if (j==nums.length){
                return nums.length-ans;
            }else {
                i=j+1;
                ans+=2;
            }
        }
        return nums.length-ans;
    }

    public long[] kthPalindrome(int[] queries, int intLength) {
        long max = 1;
        if (intLength == 1){
            max = 9;
        }else {
            int temp = (intLength+1)/2-1;
            max = 9;
            while (temp>0){
                max *= 10;
                temp--;
            }
        }
        long[] ans = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i]>max){
                ans[i] = -1;
            }else {
                ans[i] = find(queries[i],intLength);
            }
        }
        return ans;
    }

    private long find(int query, int intLength) {
        if (intLength==1){
            return query-1;
        }
        // 2 : 9           1
        // 3 : 9*10        2
        // 4 : 9 *10       2
        int half = (intLength+1)/2;
        char[] chars = new char[half];
        Arrays.fill(chars,'0');
        chars[0]='1';
        int k = query-1;
        int l = half-1;
        while (k>0){
            chars[l] += k%10;
            l--;
            k/=10;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(chars));
        if (intLength%2==0){
            sb.append(new StringBuilder(sb).reverse());
        }else {
            for (int i = half-2; i >=0 ; i--) {
                sb.append(chars[i]);
            }
        }
        return Long.parseLong(sb.toString());
    }

    //hard
/*    public int maxValueOfCoins(List<List<Integer>> piles, int k) {

    }*/

}
