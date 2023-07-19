package mid;

/**
 * @author chenz at 17:00 on 2023/1/4 .
 */
public class L1802 {

    public int maxValue(int n, int index, int maxSum) {
        int l = 1;
        int r = maxSum;
        while (l<r){
            int mid = (r+l+1)/2;
            if (fun(n,index,mid)>maxSum){
                r=mid-1;
            }else {
                l=mid;
            }
        }
        return l;
    }
    long fun(int n,int index,int val){
        long sum = val;
        if (val>index){
            sum+= (long) (val - index + val - 1) *index/2;
        }else {
            sum+= (long) (val-1+1)*(val-1)/2+ index-(val-1);
        }
        index = n-1-index;
        if (val>index){
            sum+= (long) (val - index + val - 1) *index/2;
        }else {
            sum+= (long) (val-1+1)*(val-1)/2+ index-(val-1);
        }
        return sum;
    }
}
