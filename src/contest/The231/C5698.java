package contest.The231;

/**
 * Created by chenz at 10:54 on 2021/3/7
 */
public class C5698 {
    public int minElements(int[] nums, int limit, int goal) {
        long temp=goal;
        for (int i = 0; i < nums.length; i++) {
            temp-=nums[i];
        }
        temp = Math.abs(temp);
        return (int) ((temp+limit-1)/limit);
    }
}
