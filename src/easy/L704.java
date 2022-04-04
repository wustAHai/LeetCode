package easy;

public class L704 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return  -1;
        }
        int left = 0;
        int right = nums.length-1;
        int mid = left + (right-left)/2;
        while (left <= right){
            if (target > nums[mid]){
                left = mid + 1;
            }else if (target < nums[mid]){
                right = mid -1;
            }else {
                return mid;
            }
            mid = left + (right - left)/2;
        }
        return -1;
    }
}
