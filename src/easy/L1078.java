package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz at 12:52 on 2021/12/26 .
 */
public class L1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] s = text.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length - 2; i++) {
            if (s[i].equals(first)&&s[i+1].equals(second)){
                list.add(s[i+2]);
            }
        }
        return  list.toArray(new String[list.size()]);
    }
}
