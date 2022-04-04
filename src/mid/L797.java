package mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L797 {
    int[][] graph;
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        dfs(0);
        return ans;
    }
    private void dfs(int i){
        temp.add(i);
        if (i==graph.length-1){
           ans.add(new ArrayList<>(temp));
        }else {
            int[] ints = graph[i];
            for (int j = 0; j < ints.length; j++) {
                dfs(ints[j]);
                temp.removeLast();
            }
        }
    }
}
