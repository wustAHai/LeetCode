package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenz at 19:11 on 2022/7/14 .
 */
public class L745 {
    public static void main(String[] args) {
        String[] words = {"abc"};
        WordFilter wordFilter = new WordFilter(words);
         System.out.println(wordFilter);
    }
}

class WordFilter {
    Trie trie;

    public WordFilter(String[] words) {
        trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            Trie cur = trie;
            int m = str.length();
            for (int j = 0; j < m; j++) {
                Trie temp = cur;
                for (int k = j; k < m; k++) {
                    String key = new StringBuilder().append(str.charAt(k)).append('#').toString();
                    if (!temp.children.containsKey(key)) {
                        temp.children.put(key, new Trie());
                    }
                    Trie child = temp.children.get(key);
                    child.weight = i;
                    temp = child;
                }
                temp = cur;
                for (int k = j; k < m; k++) {
                    String key = new StringBuilder().append('#').append(str.charAt(m - 1 - k)).toString();
                    if (!temp.children.containsKey(key)) {
                        temp.children.put(key, new Trie());
                    }
                    Trie child = temp.children.get(key);
                    child.weight = i;
                    temp = child;
                }
                temp = cur;
                String key = new StringBuilder().append(str.charAt(j)).append(str.charAt(m - 1 - j)).toString();
                if (!temp.children.containsKey(key)) {
                    temp.children.put(key, new Trie());
                }
                Trie child = temp.children.get(key);
                child.weight = i;
                cur = child;
            }
        }
    }

    public int f(String pref, String suff) {
        int m = Math.max(pref.length(), suff.length());
        Trie temp = trie;
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i < pref.length() ? pref.charAt(i) : '#');
            sb.append(i<suff.length() ? suff.charAt(suff.length()-1-i):'#');
            temp = temp.children.get(sb.toString());
            if (temp == null){
                return  -1;
            }
            if (i==m-1){
                return temp.weight;
            }
        }
        return -1;
    }
}

class Trie {
    Map<String, Trie> children;
    int weight;

    Trie() {
        children = new HashMap<>();
    }
}