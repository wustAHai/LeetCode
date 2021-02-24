package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenz at 9:26 on 2021/1/5
 */
public class L830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> listList = new ArrayList<>();
        if (s == null || s.length() < 3) {
            return listList;
        }
        for (int i = 0; i < s.length() - 2; i++) {
            char ch = s.charAt(i);
            List<Integer> list;
            if (ch == s.charAt(i + 1) && ch == s.charAt(i + 2)) {
                list = new ArrayList<>();
                list.add(i);
                int j = i + 2;
                while (j < s.length() && s.charAt(j) == ch) {
                    j++;
                }
                j--;
                list.add(j);
                i = j;
                listList.add(list);
            }
        }
        return listList;
    }
}
