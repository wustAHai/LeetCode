package easy;

public class L35 {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int m;
        while (l<=r){
            m = l + (r-l)/2;
            if (nums[m]==target){
                return  m;
            }else if (nums[m]>target){
                r = m-1;
            }else {
                l = m+1;
            }
        }
        return l;
    }
}
