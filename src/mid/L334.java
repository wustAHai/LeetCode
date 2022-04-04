package mid;

import java.util.Stack;

/**
 * @author chenz at 1:43 on 2022/1/12 . 思考要更高一层
 */
public class L334 {
    public boolean increasingTriplet(int[] nums) {
        int a = nums[0], b = 0;
        int c = 0;
        int l1 = 0;
        int l = 1;
        for (int i = 1; i < nums.length; i++) {
            if (l == 1) {
                if (a > nums[i]) {
                    a = nums[i];
                }
                if (a < nums[i]) {
                    b = nums[i];
                    l++;
                    continue;
                }
            }
            if (l == 2) {
                if (nums[i] > b) {
                    return true;
                } else if (nums[i] < b && nums[i] > a) {
                    b = nums[i];
                } else if (nums[i] <= a) {
                    if (l1 == 0) {
                        c = nums[i];
                        l1++;
                    } else if (l1 == 1) {
                        if (nums[i] < c) {
                            c = nums[i];
                        } else if (nums[i] > c) {
                            a= c;
                            b= nums[i];
                            l1=0;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2,1,5,0,4,6};
        L334 l334 = new L334();
        l334.increasingTriplet(a);
    }
}
