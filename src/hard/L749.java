package hard;

import java.util.*;

/**
 * @author chenz at 18:58 on 2022/7/18 .
 */
public class L749 {
    private static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    Map<Integer, Set<Integer>> nearPoint= new HashMap<>();
    Map<Integer,Integer> wall = new HashMap<>();
    int m;
    int n;
    public int containVirus(int[][] isInfected) {
         m = isInfected.length;
         n = isInfected[0].length;
        int ans = 0;
        while (true){
            int idx = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j]==1){
                        idx++;
                        bfs(isInfected,i,j,idx);
                    }
                }
            }
            int maxIdx = 0;
            int maxSize = 0;
            for (Map.Entry<Integer, Set<Integer>> integerSetEntry : nearPoint.entrySet()) {
                if (maxSize<integerSetEntry.getValue().size()){
                    maxSize = integerSetEntry.getValue().size();
                    maxIdx = integerSetEntry.getKey();
                }
            }
            if (maxIdx>0){
                ans = Math.max(ans,wall.get(maxIdx));
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (isInfected[i][j]==-maxIdx){
                            isInfected[i][j]=2;
                        }else if (isInfected[i][j]<0){
                            isInfected[i][j] = 1;
                        }
                    }
                }
                for (Map.Entry<Integer, Set<Integer>> integerSetEntry : nearPoint.entrySet()) {
                    if (integerSetEntry.getKey()!=maxIdx){
                        Set<Integer> value = integerSetEntry.getValue();
                        for (Integer integer : value) {
                            int r = integer/n;
                            int c = integer%n;
                            isInfected[r][c] = 1;
                        }
                    }
                }
            }
            nearPoint.clear();
            wall.clear();
            if (idx == 0 || idx == 1){
                return ans;
            }
        }
    }

    private void bfs(int[][] isInfected, int i, int j, int idx) {
        Deque<Integer> deque = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        deque.push(i*n+j);
        int w = 0;
        isInfected[i][j] = -idx;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int k = 0; k < size; k++) {
                Integer first = deque.pollFirst();
                int r  = first/n;
                int c  = first%n;
                for (int[] ints : dir) {
                    int  r0 = ints[0]+r;
                    int  c0 = ints[1]+c;
                    if (0<=r0&&r0<m&&c0<n&&0<=c0){
                        if (isInfected[r0][c0] == 1){
                            isInfected[r0][c0] = -idx;
                            deque.add(r0*n+c0);
                        }else if (isInfected[r0][c0] == 0){
                            w++;
                            set.add(r0*n+c0);
                        }
                    }
                }
            }
        }
        wall.put(idx,w);
        nearPoint.put(idx,set);
    }
}
