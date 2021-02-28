package contest.The230;

import java.util.List;

/**
 * Created by chenz at 10:32 on 2021/2/28
 */
public class C5689 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans=0;
        int index=0;
        if ("color".equals(ruleKey)){
            index=1;
        }else if ("name".equals(ruleKey)){
            index=2;
        }
        for (List<String> list :
                items) {
            if (ruleValue.equals(list.get(index))){
                ans++;
            }
        }
        return ans;
    }

}
