package contest.The275;

/**
 * @author chenz at 10:26 on 2022/1/9 .
 */
public class S2 {
    public int minSwaps(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==1){
                total ++;
            }
        }
        if (total == 0|| total == 1){
            return  0;
        }
        int a = 0;
        int max = 0;
        for (int i = 0; i < total; i++) {
            if (nums[i]==1){
                a++;
            }
        }
        for (int i = total; i < nums.length+total; i++) {
            if (nums[i-total]==1){
                a--;
            }
            if (nums[i%nums.length]==1){
                a++;
            }
            max = Math.max(a,max);
        }
        return total - max;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,1,1,0,0};
        S2 s2 = new S2();
        s2.minSwaps(nums);
    }
}
