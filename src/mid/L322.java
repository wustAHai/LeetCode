package mid;

import java.util.Arrays;

/**
 * @author chenz at 18:55 on 2023/3/6 .
 */
public class L322 {

    // f(k)  = min(f(k-v)+1,f(k))
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int[] f = new int[amount+1];
        Arrays.fill(f,-1);
        f[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (f[i-coin]!=-1){
                    if (f[i]==-1){
                        f[i] = f[i-coin]+1;
                    }else {
                        f[i]= Math.min(f[i],f[i-coin]+1);
                    }
                }
            }
        }
        return f[amount];
    }

    public int maxValue(int[][] grid) {
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i]+=grid[0][i-1];
        }
        for (int i = 1; i < grid.length; i++) {
           grid[i][0]+=grid[i-1][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j <grid[0].length; j++) {
                grid[i][j]+=Math.max(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
