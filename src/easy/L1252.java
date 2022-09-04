package easy;

/**
 * @author chenz at 19:17 on 2022/7/12 .
 */
public class L1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int[] r = new int[m];
        int[] c = new int[n];
        for (int[] index : indices) {
            r[index[0]]++;
            c[index[1]]++;
        }
        int oddR = 0;
        int oddC = 0;
        for (int i : r) {
            if ((i&1) ==1){
                oddR ++;
            }
        }
        for (int i : c) {
            if ((i&1)==1){
                oddC ++;
            }
        }
        return  oddR*n + oddC*m - 2*oddR*oddC;
    }
}
