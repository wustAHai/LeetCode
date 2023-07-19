package mid;

import java.util.List;

/**
 * @author chenz at 19:08 on 2022/7/11 .
 */
public class L648 {


    public String replaceWords(List<String> dictionary, String sentence) {
        DictTree root = new DictTree();
        for (String s : dictionary) {
            root.addString(root,s);
        }
        String[] s = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            sb.append(root.search(root,s[i]));
            if (i!=s.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
class DictTree{
    DictTree[] nodes = new DictTree[26];
    int cnt = 0;
    boolean closed;

    void addString(DictTree root,String str){
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i)-'a';
            DictTree node = root.nodes[index];
            if (node==null){
                node = new DictTree();
                root.nodes[index]  = node;
            }
            if (i==str.length()-1){
                node.closed = true;
            }
            if (node.closed){
                return;
            }
            root = node;
        }
    }
    String search(DictTree root,String str){
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i)-'a';
            DictTree node = root.nodes[index];
            if (node == null){
                return str;
            }else {
                if (node.closed){
                    return str.substring(0,i+1);
                }else {
                    root = node;
                }
            }
        }
        return str;
    }
}
