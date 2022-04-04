package contest.The274;

/**
 * @author chenz at 10:43 on 2022/1/2 .
 */
public class C5968 {
    public int numberOfBeams(String[] bank) {
        int ans = 0;
        int r = bank.length;
        int[] nums = new int[r];
        for (int j = 0;j<r;j++) {
            String s = bank[j];
            int num = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)=='1'){
                    num++;
                }
            }
            nums[j] = num;
        }
        int prev = 0;
        for (int i = 0; i < r; i++) {
            if(nums[i]==0){
                continue;
            }else {
                ans+= prev *nums[i];
                prev = nums[i];
            }
        }
        return ans;
    }
}
