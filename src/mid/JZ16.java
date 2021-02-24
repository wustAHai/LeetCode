package mid;

/**
 * Created by chenz at 0:36 on 2021/2/6
 */
public class JZ16 {
    public double myPow(double x, int n) {
        double temp = x;
        x = 1.0;
        if (temp == 1.0 || n == 0) {
            return x;
        }
        double flag = 1.0;
        if (temp < 0 && n % 2 == 1) {
            flag = -flag;
        }
        if (n < 0) {
            while (n < 0) {
                x *= 1 / temp;
                n++;
                if (x == 0.0 || x == 1.0) {
                    break;
                }
            }
        } else {
            while (n > 0) {
                x *= temp;
                n--;
                if (x == 0.0 || x == 1.0) {
                    break;
                }
            }
        }
        return flag * Math.abs(x);
    }
}
