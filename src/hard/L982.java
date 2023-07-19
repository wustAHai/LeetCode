package hard;

/**
 * @author chenz at 19:23 on 2023/3/4 .
 */
public class L982 {
    public int countTriplets(int[] nums) {
        int[] arr = new int[1<<16];
        for (int num : nums) {
            for (int i : nums) {
                ++arr[num&i];
            }
        }
        int ret = 0;
        for (int num : nums) {
           int x =  ((1<<16)-1)^num;
            for (int i = x; i !=0 ; i=(i-1)&x) {
                ret+=arr[i];
            }
            ret+=arr[0];
        }
        return ret;
    }


}
