package mid;

/**
 * @author chenz at 21:18 on 2022/3/15 .
 */
public class L2044 {
    int max ;
    int cnt ;
    int [] nums;
    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        dfs(0,0);
        return cnt;
    }
    void dfs(int i,int val){
        if (i== nums.length){
            if (val>max){
                max = val;
                cnt=1;
            }else if (val==max){
                cnt++;
            }
            return;
        }
        dfs(i+1,val|nums[i]);
        dfs(i+1,val);
    }
}
