package mid;

/**
 * @author chenz at 19:50 on 2022/8/27 .
 */
public class L2384 {
    public String largestPalindromic(String num) {
        int[] nums = new int[10];
        char[] chars = num.toCharArray();
        for (char aChar : chars) {
            nums[aChar-'0']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >=0 ; i--) {
            if (sb.length()==0&&i==0){
                break;
            }
            for (int j = 0; j < nums[i]/2; j++) {
                sb.append(i);
            }
        }
        int mid = -1;
        for (int i = 9; i >=0 ; i--) {
            if (nums[i]%2==1){
                mid=i;
                break;
            }
        }
        if (mid==-1&&sb.length()==0){
            return "0";
        }
        StringBuilder sb1 = new StringBuilder(sb);
        if (mid!=-1){
            return sb.append(mid).append(sb1.reverse()).toString();
        }
        return sb.append(sb1.reverse()).toString();
    }
}
