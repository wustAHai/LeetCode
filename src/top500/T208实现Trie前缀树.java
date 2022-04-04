package top500;

import java.util.*;

/**
 * @author chenz at 13:46 on 2022/3/23 .
 */
public class T208实现Trie前缀树 {


}
class TireNode{
    TireNode[] arr = new TireNode[26];
    boolean isEnd;
}
class Trie {
    TireNode root;

    public Trie() {
        root = new TireNode();
    }

    public void insert(String word) {
        TireNode temp = root;
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            int index = ch - 'a';
            if (temp.arr[index]==null){
                temp.arr[index] = new TireNode();
            }
            temp =  temp.arr[index];
        }
        temp.isEnd=true;
    }

    public boolean search(String word) {
        TireNode temp = root;
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            int index = ch - 'a';
            if (temp.arr[index]==null){
                return false;
            }
            temp =  temp.arr[index];
        }
        return temp.isEnd;
    }

    public boolean startsWith(String prefix) {
        TireNode temp = root;
        char[] chars = prefix.toCharArray();
        for (char ch : chars) {
            int index = ch - 'a';
            if (temp.arr[index]==null){
                return false;
            }
            temp =  temp.arr[index];
        }
        return true;
    }
}
class Encrypter {

    private Map<Character,String> kvMap = new HashMap<>();
    private Map<String,Set<Character>> vkMap = new HashMap<>();
    private  Trie trie = new Trie();

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        for (int i = 0; i < keys.length; i++) {
            kvMap.put(keys[i],values[i]);
            Set<Character> orDefault = vkMap.getOrDefault(values[i], new HashSet<>());
            orDefault.add(keys[i]);
            vkMap.put(values[i],orDefault);
        }
        for (String s : dictionary) {
            trie.insert(s);
        }
    }

    public String encrypt(String word1) {
        StringBuilder sb  = new StringBuilder();
        for (int i = 0; i < word1.length(); i++) {
            sb.append(kvMap.get(word1.charAt(i)));
        }
        return sb.toString();
    }

    public int decrypt(String word2) {
        return 0;
    }
}


