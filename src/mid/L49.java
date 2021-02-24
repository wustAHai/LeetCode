package mid;

import org.junit.Test;

import java.util.*;

public class L49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String key = Arrays.toString(s);
            List<String> temp = hashMap.getOrDefault(key, new ArrayList<String>());
            if (temp.size() == 0) {
                hashMap.put(key, temp);
            }
            temp.add(strs[i]);

        }
        return new ArrayList<List<String>>(hashMap.values());
    }


    @Test
    public void test() {
        String[] a = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams(a);
        System.out.println(res);
    }

}
