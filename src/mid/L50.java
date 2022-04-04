package mid;

public class L50 {
    public double myPow(double x, int n) {
        double ans = 1.0;
        double temp =  x;
        long k = n;
        if (k>0){
            while (k>0){
                if (k%2==1){
                    ans *= temp;
                }
                temp = temp *temp;
                k =k/2;
            }
        }else {
            k = -k;
            while (k>0){
                if (k%2==1){
                    ans /= temp;
                }
                temp = temp *temp;
                k =k/2;
            }
        }
        return ans;
    }
}
