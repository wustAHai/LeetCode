package easy;

/**
 * Created by chenz at 11:36 on 2021/1/1
 */
public class L367 {
    public boolean isPerfectSquare(int num) {
        long i = 1;
        while (i * i < num) {
            i++;
        }
        return i * i == num;
    }
}
