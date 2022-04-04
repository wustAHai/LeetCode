package easy;

public class L977 {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0, j = nums.length -1, pos = nums.length - 1; i <= j ;) {
            if (nums[i]*nums[i]<nums[j]*nums[j]){
                ans[pos] = nums[j]*nums[j];
                j--;
            }else {
                ans[pos] = nums[i]*nums[i];
                i++;
            }
            pos--;
        }
        return ans;
    }
}
