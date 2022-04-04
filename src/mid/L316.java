package mid;

import org.junit.Test;

import java.util.*;

public class L316 {
    public String removeDuplicateLetters(String s) {
        TreeMap<Character, ArrayList<Integer>> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            ArrayList<Integer> arrayList = map.getOrDefault(s.charAt(i), new ArrayList<Integer>());
            arrayList.add(i);
            map.put(s.charAt(i), arrayList);
        }
        StringBuilder sb = new StringBuilder();
        int[] lastIndex = {-1};
        while (map.size() > 0) {
            Iterator<Character> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                char ch = iterator.next();
                if (isValid(ch, map, lastIndex)) {
                    sb.append(ch);
                    iterator.remove();
                    break;
                }
            }
        }

        return sb.toString();
    }

    public boolean isValid(char ch, TreeMap<Character, ArrayList<Integer>> map, int[] lastIndex) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>(map.values());
        ArrayList<Integer> arrayList = map.get(ch);
        int first = -1;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) > lastIndex[0]) {
                first = arrayList.get(i);
                break;
            }
        }
        for (int i = 0; i < arrayLists.size(); i++) {
            if (first > arrayLists.get(i).get(arrayLists.get(i).size() - 1)) {
                return false;
            }
        }
        lastIndex[0] = first;
        return true;
    }

    @Test
    public void test() {
        System.out.println(removeDuplicateLetters("bcabc"));
    }
}
