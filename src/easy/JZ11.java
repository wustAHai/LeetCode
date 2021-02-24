package easy;

/**
 * Created by chenz at 16:20 on 2021/2/3
 */
public class JZ11 {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int length = numbers.length;
        if (length == 1) {
            return numbers[0];
        }
        int i = 0;
        while (i + 1 < length) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
            i++;
        }
        return numbers[0];
    }
}
