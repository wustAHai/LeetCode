package easy;

/**
 * @author chenz at 19:38 on 2022/7/11 .
 */
public class L1217 {
    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;
        for (int i : position) {
            if ((i&1)==1){
                odd++;
            }else {
                even ++;
            }
        }
        return Math.min(odd,even);
    }
}
