package mid;

/**
 * @author chenz at 18:45 on 2022/12/9 .
 */
public class L1780 {
    public boolean checkPowersOfThree(int n) {
        int[] arr = new int[16];
        int[] cnt = new int[16];
        int t = 1;
        for (int i = 0; i < 16; i++) {
            arr[i] = t;
            t*=3;
        }
        while (n>0){
            for (int i = 0; i < 15; i++) {
                if (n>=arr[i]&&n<arr[i+1]){
                    n-=arr[i];
                    cnt[i]++;
                    if (cnt[i]==2){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
