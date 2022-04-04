package contest.Th60;

public class L5846 {
    public int findMiddleIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int midIndex = 0;
        int leftSum = 0;
        int rightSum = sum - leftSum - nums[midIndex];
        while(midIndex<nums.length){
            if (leftSum==rightSum){
                return midIndex;
            }
            midIndex++;
            leftSum+=nums[midIndex-1];
            if (midIndex<nums.length){
                rightSum-=nums[midIndex];
            }
        }
        return -1;
    }
}
