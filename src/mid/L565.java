package mid;

/**
 * @author chenz at 13:43 on 2022/7/17 .
 */
public class L565 {
    public int arrayNesting(int[] nums) {
        boolean [] visited = new  boolean[nums.length];
        int maxLen =0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            while (!visited[i]){
                visited[i] =true;
                i = nums[i];
                cnt ++;
            }
            maxLen = Math.max(cnt,maxLen);
        }
        return maxLen;
    }
}
