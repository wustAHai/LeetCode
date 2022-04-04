package easy;

/**
 * Created by chenz at 12:15 on 2021/2/16
 */
public class JZ61 {
    public boolean isStraight(int[] nums) {
        int[] pai = new int[14];
        for (int i = 0; i < nums.length; i++) {
            pai[nums[i]]++;
        }
        for (int i = 1; i < 14; i++) {
            if (pai[i] > 1) {
                return false;
            }
        }
        int que = 0;
        for (int i = 1; i < 5; i++) {
            if (pai[i] == 0) {
                que++;
            }
        }
        int q = 6;
        int p = 1;
        while (q < 14) {
            if (pai[q] == 0) {
                que++;
            }
            if (que == pai[0]) {
                return true;
            }
            q++;
            if (pai[p] == 0) {
                que--;
            }
            p++;
        }
        return false;
    }
}
