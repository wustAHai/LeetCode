package easy;

import java.util.HashMap;

public class L205 {

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> s2t = new HashMap<>();
        HashMap<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            if (s2t.containsKey(chs) && s2t.get(chs) != cht) {
                return false;
            }
            if (t2s.containsKey(cht) && t2s.get(cht) != chs) {
                return false;
            }
            s2t.put(chs, cht);
            t2s.put(cht, chs);
        }
        return true;
    }
}
