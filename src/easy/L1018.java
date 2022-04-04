package easy;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenz at 11:51 on 2021/1/14
 */
public class L1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> booleans = new ArrayList<>();
        if (A == null || A.length == 0) {
            return booleans;
        }
        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("2");
        for (int i = 0; i < A.length; i++) {
            a = a.multiply(b);
            a.add(new BigInteger("" + A[i]));
            booleans.add(a.mod(new BigInteger("5")).intValue() == 0);
        }
        return booleans;
    }

    @Test
    public void test() {
        int[] a = {0, 1, 1};
        prefixesDivBy5(a);
    }
}
