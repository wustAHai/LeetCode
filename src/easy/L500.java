package easy;

import java.util.ArrayList;

/**
 * Created by chenz at 23:22 on 2021/1/19
 */
public class L500 {
    public String[] findWords(String[] words) {
        String[] arr = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int status = 0;
            boolean flag = true;
            for (int j = 0; j < words[i].length(); j++) {
                char ch = Character.toLowerCase(words[i].charAt(j));
                if (j == 0) {
                    for (int k = 0; k < arr.length; k++) {
                        if (arr[k].indexOf(ch) >= 0) {
                            status = k;
                            break;
                        }
                    }
                } else {
                    if (arr[status].indexOf(ch) < 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                arrayList.add(words[i]);
            }
        }
        return arrayList.toArray(new String[0]);
    }
}
