package hard;

import java.util.Arrays;

/**
 * @author chenz at 16:16 on 2022/7/30 .
 */
public class L952 {
    public int largestComponentSize(int[] nums) {
        int m = Arrays.stream(nums).max().getAsInt();
        Uf uf = new Uf(m+1);
        for (int num : nums) {
            for (int i = 2; i*i<= num ; i++) {
                if (num%i==0){
                    uf.union(num,i);
                    uf.union(num,num/i);
                }
            }
        }
        int [] counts = new int[m+1];
        int ans = 0;
        for (int num : nums) {
            ans = Math.max(ans, ++counts[uf.findParent(num)]);
        }
        return ans;
    }
}
class  Uf{
    private int[] parent;
    private int[] rank;

    public Uf(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
        rank = new int[size];
    }

    int findParent(int x){
        if (parent[x]!=x){
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    void union(int x,int y){
        int px = findParent(x);
        int py = findParent(y);
        if (px!=py){
            if (rank[px]>rank[py]){
                parent[py] = px;
            }else  if (rank[px]==rank[py]){
                parent[py] = px;
                rank[px]++;
            }else {
                parent[px] =py;
            }
        }
    }
}