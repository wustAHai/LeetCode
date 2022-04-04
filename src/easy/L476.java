package easy;

import org.junit.Test;

/**
 * Created by chenz at 21:48 on 2021/1/17
 */
public class L476 {
    public int findComplement(int num) {
        int temp = 1;
        int i = 1;
        while (temp < num) {
            i *= 2;
            temp += i;
        }
        return temp - num;
    }
}
