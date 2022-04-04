package easy;

public class L1973 {
    public int findGCD(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = max > nums[i] ? max : nums[i];
            min = min < nums[i] ? min : nums[i];
        }
        int mod;
        while ((mod =max%min)!=0){
            max = min;
            min = mod;
        }
        return min;
    }
}
