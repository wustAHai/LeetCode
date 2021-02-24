package easy;

/**
 * Created by chenz on 2020/12/27 11:05
 */
public class L263 {
    public boolean isUgly(int num) {
        if (num <= 1) {
            return false;
        }
        while (num > 1) {
            if (num % 2 == 0 || num % 3 == 0 || num % 5 == 0) {
                if (num % 2 == 0) {
                    num /= 2;
                }
                if (num % 3 == 0) {
                    num /= 3;
                }
                if (num % 5 == 0) {
                    num /= 5;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
