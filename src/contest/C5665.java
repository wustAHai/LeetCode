package contest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by chenz at 10:40 on 2021/1/31
 */
public class C5665 {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int start = 0;
        int index = 0;
        boolean[] visited = new boolean[adjacentPairs.length];
        for (int i = 0; i < adjacentPairs.length; i++) {
            for (int j = 0; j < adjacentPairs[i].length; j++) {
                hashMap.put(adjacentPairs[i][j], hashMap.getOrDefault(adjacentPairs[i][j], 0) + 1);
            }
        }
        Set<Integer> set = hashMap.keySet();
        for (Integer integer : set
        ) {
            if (hashMap.get(integer) == 1) {
                start = integer;
                break;
            }
        }
        List<Integer> integerList = new LinkedList<>();
        integerList.add(start);
        for (int i = 0; i < adjacentPairs.length; i++) {
            if (adjacentPairs[i][0] == start || adjacentPairs[i][1] == start) {
                visited[i] = true;
                start = adjacentPairs[i][0] + adjacentPairs[i][1] - start;
                integerList.add(start);
                break;
            }
        }
        int n = adjacentPairs.length + 1;
        while (integerList.size() < n) {
            for (int i = 0; i < adjacentPairs.length; i++) {
                if (!visited[i]) {
                    if (adjacentPairs[i][0] == start || adjacentPairs[i][1] == start) {
                        visited[i] = true;
                        start = adjacentPairs[i][0] + adjacentPairs[i][1] - start;
                        integerList.add(start);
                    }
                }
            }
        }
        int[] arr = new int[n];
        for (int i = 0; i < integerList.size(); i++) {
            arr[i] = integerList.get(i);
        }
        return arr;
    }
}
