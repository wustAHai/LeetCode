package mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz at 20:52 on 2023/4/14 .
 */
public class L1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list = new ArrayList<>();
        for (String query : queries) {
            list.add(camel(query,pattern));
        }
        return list;
    }

    private Boolean camel(String query, String pattern) {
        int i = 0;
        int j = 0;
        while (i<query.length()&&j<pattern.length()){
            char q = query.charAt(i);
            char p = pattern.charAt(j);
            if (Character.isUpperCase(q)){
                if (q==p){
                    i++;
                    j++;
                }else {
                    return false;
                }
            }else {
                i++;
                if (q==p){
                    j++;
                }
            }
        }
        while (i<query.length()&&Character.isLowerCase(query.charAt(i))){
            i++;
        }
        if (j!=pattern.length()||i!=query.length()){
            return false;
        }
        return true;
    }
}
