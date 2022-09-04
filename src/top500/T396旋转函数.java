package top500;

/**
 * @author chenz at 18:48 on 2022/4/22 .
 */
public class T396旋转函数 {
    public int maxRotateFunction(int[] nums) {
        int f = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            f+= i*nums[i];
            sum += nums[i];
        }
        int max = f;
        for (int i = 1; i < nums.length; i++) {
            f =  f - nums[nums.length-i]*(nums.length-1)+sum;
            max = Math.max(f,max);
        }
        return max;
    }
}
