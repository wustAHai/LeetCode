package top500;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz at 21:51 on 2023/3/9 .
 */
public class T77组合 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(ret,temp,n,k,1);

        return ret;
    }

    private void dfs(List<List<Integer>> ret, List<Integer> temp, int n, int k, int i) {
        if (i>n || n-i+1+temp.size()<k){
            return;
        }
        if (temp.size()==k){
            List<Integer> list = new ArrayList<>(temp);
            ret.add(list);
            return;
        }
        temp.add(i);
        dfs(ret,temp,n,k,i+1);
        temp.remove(temp.size()-1);
        dfs(ret,temp,n,k,i+1);

    }
}
