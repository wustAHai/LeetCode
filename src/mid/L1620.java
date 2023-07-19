package mid;

/**
 * @author chenz at 21:21 on 2022/11/2 .
 */
public class L1620 {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[] ans = new int[2];
        int max=0;
        for(int i = 0;i<=50;i++){
            for (int j = 0; j <= 50; j++) {
                int temp=0;
                for (int[] tower : towers) {
                   int df = (tower[0]-i)*(tower[0]-i)+(tower[1]-j)*(tower[1]-j);
                   if (df<=radius*radius){
                       temp+=tower[2]/(1+Math.sqrt(df));
                   }
                }
                if (temp>max){
                    max= temp;
                    ans[0]=i;
                    ans[1]=j;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new L1620().bestCoordinate(new int[][]{{1,2,5},{2,1,7},{3,1,9}},2);
    }
}
