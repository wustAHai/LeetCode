package mid;

public class L1894 {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        if (n==1||chalk[0]>k){
            return 0;
        }
        int[] sum = new int[n];
        sum[0] = chalk[0];
        for (int i = 1; i < n; i++) {
            sum[i] = chalk[i]+sum[i-1];
            if (sum[i]>k){
                return i;
            }
        }
        k = k%sum[n-1];
        int l = 0;
        int r = n -1;
        while (l<=r){
            int mid = (l+r)/2;
            if (sum[mid]==k){
                return mid+1;
            }else if (sum[mid]<k){
                 l = mid+1;
            }else {
                 r = mid-1;
            }
        }
        return l;
    }
}
