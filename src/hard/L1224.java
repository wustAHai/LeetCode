package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenz at 18:46 on 2022/8/18 .
 */
public class L1224 {
    public int maxEqualFreq(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int solo = 0;
        for (int i = 0; i < nums.length; i++) {
            int a  = map.getOrDefault(nums[i], 0);
            if (a==0){
                solo++;
            }else if (a==1){
                solo--;
            }
            map.put(nums[i],a+1);
            int type = map.keySet().size();
            if (type==1){
                ans=i+1;
            }else {
                if (solo!=0){
                    if (solo==1){
                        if (type==2){
                            ans=i+1;
                        }else {
                            type--;
                            if (i%type==0){
                                int p = i/type;
                                boolean ok = true;
                                for (Integer value : map.values()) {
                                    if (value<p&&value!=1){
                                        ok = false;
                                        break;
                                    }
                                }
                                if (ok){
                                    ans=i+1;
                                }
                            }
                        }
                    }else {
                        if (i-1==solo||i+1==solo){
                            ans=i+1;
                        }
                    }
                }else {
                   if (i%type==0){
                       int p = i/type;
                       boolean ok = true;
                       for (Integer value : map.values()) {
                           if (value<p){
                               ok = false;
                               break;
                           }
                       }
                       if (ok){
                           ans=i+1;
                       }
                   }
                }
            }
        }
        return ans;
    }
}
