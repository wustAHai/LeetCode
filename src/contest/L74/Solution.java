package contest.L74;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenz at 22:32 on 2022/3/19 .
 */
public class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i+=2) {
            if (nums[i]!=nums[i-1]){
                return false;
            }
        }
        return true;
    }

    public long maximumSubsequenceCount(String text, String pattern) {
        char[] chars = pattern.toCharArray();
        char[] s = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        int a=0;
        int b=0;
        for (char c : s) {
            if (c==chars[0]){
                a++;
                sb.append(c);
            }else if (c==chars[1]){
                b++;
                sb.append(c);
            }
        }
        char[] arr = sb.toString().toCharArray();
        if (arr.length==0){
            return 0;
        }
        if (chars[0]==chars[1]){
            long l = arr.length+1;
            return l*(l-1)/2;
        }
        long ans = 0;
        int tmp = b;
        for (char c : arr) {
            if (c==chars[1]){
               tmp--;
            }else {
                ans+=tmp;
            }
        }
        return Math.max(a,b)+ans;
    }

    public int halveArray(int[] nums) {
       long sum = 0;
        if (nums.length==1){
            return 1;
        }
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if (o1>o2){
                    return -1;
                }else if (o1<o2){
                    return 1;
                }
                return 0;
            }
        });
        for (int num : nums) {
            sum+=num;
            priorityQueue.add((double)num);
        }
        int n = 0;
        double l =0;
        while (l*2<sum){
            Double poll = priorityQueue.poll();
            l+=poll/2;
            priorityQueue.add(poll/2);
            n++;
        }
        return n;
    }
/*    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {

    }*/

    public static void main(String[] args) {
        System.out.println('1'%2);
    }
}
