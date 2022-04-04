package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenz at 18:01 on 2021/12/15 .
 */
public class L851 {

    ArrayList<ArrayList<Integer>> arrayList;
    boolean[] visited;
    int[] answer;
    int n;
    int[]quiet;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        this.quiet =quiet;
        n = quiet.length;
        answer = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            answer[i] = -1;
        }
        arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> integers = new ArrayList<>();
            arrayList.add(integers);
        }
        for (int[] ints : richer) {
            int a = ints[0];
            int b = ints[1];
            arrayList.get(b).add(a);
        }
        for (int i = 0; i < n; i++) {
            dfs(i);
            Arrays.fill(visited,false);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < quiet.length; i++) {
            map.put(quiet[i],i);
        }
        for (int i = 0; i < answer.length; i++) {
            answer[i] = map.get(answer[i]);
        }
        return answer;
    }
    int dfs(int i){
        ArrayList<Integer> integers = arrayList.get(i);
        visited[i] = true;
        int min = quiet[i];
        if (integers.isEmpty()||quiet[i]==0){
            answer[i] = quiet[i];
        }else if (answer[i]!= -1){
            return answer[i];
        }else {
            for (Integer integer : integers) {
                if (!visited[integer]){
                    min = Math.min(min,dfs(integer));
                }else {
                    min = Math.min(min,answer[integer]);
                }
            }
        }
        answer[i] = min;
        return min;
    }
}
