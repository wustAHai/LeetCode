package easy;

import java.util.HashSet;
import java.util.Set;

public class L231 {
    public boolean isPowerOfTwo(int n) {
        Set<Integer> set = new HashSet<>();
        long i = 1;
        while (i < Integer.MAX_VALUE) {
            set.add((int) i);
            i = i * 2;
        }
        return set.contains(n);
    }
}
