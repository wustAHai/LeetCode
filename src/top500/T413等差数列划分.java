package top500;

/**
 * @author chenz at 20:56 on 2022/9/1 .
 */
//1 3 1  2 4  1 + 2  3 5   1 + 2  + 3              （l+1
public class T413等差数列划分 {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = 0;
        int pre = 0;
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (len == 0){
                pre = nums[i]-nums[i-1];
                len++;
            }else {
                if (nums[i]-nums[i-1]==pre){
                    len++;
                }else {
                    sum += (len)*(len-1)/2;
                    pre = nums[i]-nums[i-1];
                    len = 1;
                }
            }
        }
        return sum+(len)*(len-1)/2;
    }
}
