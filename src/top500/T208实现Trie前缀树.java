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



