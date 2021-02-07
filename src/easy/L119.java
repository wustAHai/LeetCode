package easy;

import java.util.ArrayList;
import java.util.List;

public class L119 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ar1 = new ArrayList<>();
        List<Integer> ar2 = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            ar2.clear();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    ar2.add(1);
                } else {
                    ar2.add(ar1.get(j - 1) + ar1.get(j));
                }
            }
            if (i < rowIndex) {
                ar1.clear();
                ar1.addAll(ar2);
            }
        }
        return ar2;
    }

    public static void main(String[] args) {
        String a = "aaa\\1";
        System.out.println(a);
    }
}
