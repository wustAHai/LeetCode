package contest.The47;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by chenz at 22:40 on 2021/3/6
 */
public class L5681 {
    public boolean checkPowersOfThree(int n) {
        int [] temp= new int[15];
        temp[0]=1;
        for (int i = 1; i < 15; i++) {
            temp[i]=temp[i-1]*3;
        }
        //System.out.println(Arrays.toString(temp));

        return dfs(temp,n,0);
    }

    private boolean dfs(int[] temp, int n,int i) {
        if (n==0){
            return true;
        }
        if (n<0||i>=temp.length){
            return false;
        }
        return  dfs(temp,n-temp[i],i+1)||dfs(temp,n,i+1);
    }

    @Test
    public void  test(){
        checkPowersOfThree(1);
    }
}
