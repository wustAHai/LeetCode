package easy;

/**
 * Created by chenz at 12:53 on 2021/2/28
 */
public class L896 {
    public boolean isMonotonic(int[] A) {
        return  isAsc(A)||isDsc(A);
    }

    private boolean isAsc(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i]<a[i-1]){
                return false;
            }
        }
        return true;
    }
    private boolean isDsc(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i]>a[i-1]){
                return false;
            }
        }
        return true;
    }

}
