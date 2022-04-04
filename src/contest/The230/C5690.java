package contest.The230;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenz at 10:40 on 2021/2/28
 */
public class C5690 {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(toppingCosts,list,0,0);
        list.add(0);
        list.sort(null);
      //  System.out.println(list);
        Arrays.sort(baseCosts);
        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i < baseCosts.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                arrayList.add(baseCosts[i]+list.get(j));
            }
        }
        arrayList.sort(null);
     //   System.out.println(arrayList);
        int ans=arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++) {
            if (Math.abs(target-ans)>Math.abs(target-arrayList.get(i))){
                ans=arrayList.get(i);
            }
        }
        return ans;
    }

    private void dfs(int[] toppingCosts, ArrayList<Integer> list,int start,int temp) {
        if (start<toppingCosts.length){
            list.add(toppingCosts[start]+temp);
            list.add(toppingCosts[start]*2+temp);
            dfs(toppingCosts,list,start+1,temp);
            dfs(toppingCosts,list,start+1,toppingCosts[start]+temp);
            dfs(toppingCosts,list,start+1,toppingCosts[start]*2+temp);
        }else {
            return;
        }
    }
    @Test
    public void testClo(){
        int [] baseCosts ={5830,4245,3002,8874,3406,5036,3264};
        int [] toppingCosts={4037,5906,1334,4601,1465,7339,1483};
        int target =9441;
        System.out.println(closestCost(baseCosts,toppingCosts,target));
    }
}
