package mid;

import java.util.*;

/**
 * @author chenz at 9:26 on 2022/10/16 .
 */
public class L886 {
    int[] arr;
    ArrayList<Integer>[] lists;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (dislikes.length==0){
            return true;
        }
        arr = new int[n+1];
        lists = new ArrayList[n+1];
        for (int i = 0; i < dislikes.length; i++) {
            int a = dislikes[i][0];
            int b = dislikes[i][1];
            if (lists[a]==null){
                lists[a] = new ArrayList<>();
            }
            if (lists[b]==null){
                lists[b] = new ArrayList<>();
            }
            lists[a].add(b);
            lists[b].add(a);
        }
        for (int i = 0; i < lists.length; i++) {
            if (lists[i]!=null){
                if (!dfs(i,1)){
                    return false;
                }
            }
        }
        return true;
    }
    boolean dfs(int i,int val){
        if (arr[i]!=0){
            if (val==0){
                return true;
            }else if (val!=arr[i]){
                return false;
            }
            return true;
        }
        if (val==0){
            val=1;
        }
        arr[i]=val;
        for (Integer integer : lists[i]) {
            if (!dfs(integer,-val)){
                return false;
            }
        }
        return true;
    }
}
