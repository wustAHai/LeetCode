package easy;

/**
 * Created by chenz at 7:51 on 2021/2/4
 */
public class JZ17 {
    public int[] printNumbers(int n) {
        int max = 0;
        while (n > 0) {
            max *= 10;
            max += 9;
            n--;
        }
        int[] result = new int[max];
        for (int i = 0; i < max; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
