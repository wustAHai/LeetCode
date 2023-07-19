package mid;

import java.util.Arrays;

/**
 * @author chenz at 19:31 on 2022/12/9 .
 */
public class L1744 {
    int ans ;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        Arrays.sort(baseCosts);
        ans = baseCosts[0];
        for (int baseCost : baseCosts) {
            dfs(toppingCosts,baseCost,target,0);
        }
        return ans;
    }
    void dfs(int[] toppingCosts,int cur,int target,int p){
        int i =  Math.abs(cur-target) - Math.abs(ans-target);
        if (i<0){
            ans = cur;
        }else if (i==0){
            ans = Math.min(ans,cur);
        }else {
            if (cur>ans){
                return;
            }
        }
        if (p==toppingCosts.length){
            return;
        }
        dfs(toppingCosts,cur,target,p+1);
        dfs(toppingCosts,cur+toppingCosts[p],target,p+1);
        dfs(toppingCosts,cur+toppingCosts[p]*2,target,p+1);
    }
}
