package mid;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author chenz at 19:12 on 2022/10/28 .
 */
public class L907 {
/*    public int sumSubarrayMins(int[] arr) {
        long ans=0;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                min=Math.min(min,arr[j]);
                ans+=min;
            }
        }
    }*/

    public int sumSubarrayMins(int[] arr) {
        int[] left = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            //严格小于
            while (!stack.isEmpty()&&arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                left[i]=-1;
            }else {
                left[i]=stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        int[] right = new int[arr.length];
        //小于等于
        for (int i = arr.length-1;i>=0;i--){
            while (!stack.isEmpty()&&arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                right[i]=arr.length;
                stack.push(i);
            }else {
                right[i] = stack.peek();
                stack.push(i);
            }
        }
        long ans = 0L;
        for (int i = 0; i < arr.length; i++) {
            ans+= (long) arr[i] *(i-left[i])*(right[i]-i);
        }
        return (int) (ans%1000000007);
    }

    public static void main(String[] args) {
        System.out.println(new L907().sumSubarrayMins(new int[]{71,55,82,55}));
    }

}
