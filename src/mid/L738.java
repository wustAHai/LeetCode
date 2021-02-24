package mid;

import org.junit.Test;

import java.util.Arrays;

public class L738 {
    public int monotoneIncreasingDigits(int N) {
        char[] arr = (Integer.toString(N)).toCharArray();
        int i = 1;
        while (i < arr.length && arr[i] >= arr[i - 1]) {
            i++;
        }
        if (i == arr.length) {
            return N;
        }
        i--;
        --arr[i];
        int j = 0;
        while (j < i) {
            if (arr[j] > arr[i]) {
                break;
            }
            j++;
        }
        arr[j] = arr[i];
        j++;
        for (; j < arr.length; j++) {
            arr[j] = '9';
        }
        return Integer.parseInt(new String(arr));
    }


    @Test
    public void test() {
        System.out.println(monotoneIncreasingDigits(332));
    }
}
