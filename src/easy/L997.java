package easy;

/**
 * @author chenz at 11:33 on 2021/12/19 .
 */
public class L997 {
    public int findJudge(int n, int[][] trust) {
        int [][] arr  =  new int[n][2];
        for (int i = 0; i < trust.length; i++) {
            int a = trust[i][0];
            int b = trust[i][1];
            arr[b][0]++;
            arr[a][1]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0]==n-1&&arr[i][1]==0){
                return i;
            }
        }
        return -1;
    }
}
