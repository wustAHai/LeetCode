package hard;

/**
 * @author chenz at 18:02 on 2022/10/6 .
 */
public class L927 {
    public int[] threeEqualParts(int[] arr) {
        int cnt=0;
        for (int i : arr) {
            if (i==1){
                cnt++;
            }
        }
        if (cnt%3!=0){
            return new int[]{-1,-1};
        }
        cnt/=3;
        int p = 0;
        int c = 0;
        int q = 0;
        for (int i = 0; i < arr.length; i++) {
           if (arr[i]==1){
               p=i;
               break;
           }
        }
        for (int i = arr.length-1; i >=0 ; i--) {
            if (arr[i]==1){
                c++;
                if (c==cnt){
                    q=i;
                    break;
                }
            }
        }
        //   ....p....q....
        for (int i = p, j = q; j<arr.length ;i++,j++) {
            if (arr[i]!=arr[j]){
                return new int[]{-1,-1};
            }
        }
        int len = arr.length-q;
        p = len+p;
        int ans1 = p-1;
        while (arr[p]==0){
            p++;
        }
        for (int i = p, j = q; j<arr.length ;i++,j++) {
            if (arr[i]!=arr[j]){
                return new int[]{-1,-1};
            }
        }
        return new int[]{ans1,p+len};
    }
}
