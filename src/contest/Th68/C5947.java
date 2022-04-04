package contest.Th68;

import java.util.*;

/**
 * @author chenz at 0:40 on 2021/12/26 .
 */
public class C5947 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> strings = new HashSet<>();
        for (String supply : supplies) {
            strings.add(supply);
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < recipes.length; i++) {
            List<String> list = ingredients.get(i);
            boolean isContain =  true;
            for (String s : list) {
                if (!strings.contains(s)){
                    isContain = false;
                    break;
                }
            }
            if (isContain){
                ans.add(recipes[i]);
            }
        }
        return ans;
    }
}
