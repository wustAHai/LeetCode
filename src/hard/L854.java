package hard;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author chenz at 22:29 on 2022/9/21 .
 */
public class L854 {
    public int kSimilarity(String s1, String s2) {
        int n = s1.length();
        Queue<Pair<String,Integer>> queue = new ArrayDeque<>();
        Set<String> visit  = new HashSet<>();
        queue.offer(new Pair<>(s1,0));
        visit.add(s1);
        int step = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<String, Integer> poll = queue.poll();
                String cur = poll.getKey();
                int pos = poll.getVal();
                 if (cur.equals(s2)){
                     return step;
                 }
                 while (pos<n && cur.charAt(pos)==s2.charAt(pos)){
                     pos++;
                 }
                for (int j = pos+1; j < n; j++) {
                    if (cur.charAt(j)==s2.charAt(j)){
                        continue;
                    }
                    if (cur.charAt(j)==s2.charAt(pos)){
                        String next = swap(cur,pos,j);
                        if (!visit.contains(next)){
                            visit.add(next);
                            queue.offer(new Pair<>(next,pos+1));
                        }
                    }
                }
            }
            step++;
        }
        return step;
    }

    private String swap(String cur, int pos, int j) {
        char[] chars = cur.toCharArray();
        char ch = chars[pos];
        chars[pos] =chars[j];
        chars[j] = ch;
        return new String(chars);
    }


}
class Pair<K,V>{
    K key;
    V val;

    public Pair(K key, V val) {
        this.key = key;
        this.val = val;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getVal() {
        return val;
    }

    public void setVal(V val) {
        this.val = val;
    }
}