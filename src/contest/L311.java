package contest;

import easy.TreeNode;

import java.util.*;

/**
 * @author chenz at 10:34 on 2022/9/18 .
 */
public class L311 {
    public int longestContinuousSubstring(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = 0;
        int len = 0;
        while (i<chars.length){
            j=i;
            while (j+1<chars.length&&chars[j+1]-chars[j]==1){
                j++;
            }
            j++;
            len = Math.max(len,j-i);
            i=j;
        }
        return len;
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        int level=0;
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            level++;
            List<Integer> arr;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left==null){
                    return  root;
                }
                deque.addLast(poll.left);
                deque.addLast(poll.right);
            }
            if ((level&1)==1){
                arr = new ArrayList<>(deque.size());
                for (int i = 0; i < deque.size(); i++) {
                   arr.add( deque.get(i).val);
                }
                for (int i = 0; i < deque.size(); i++) {
                    deque.get(i).val=arr.get(deque.size()-1-i);
                }
                arr.clear();
            }
        }
        return root;
    }

    public static void main(String[] args) {
        L311 main = new L311();
        String[] words = new String[]{"abc","ab","bc","b"};
        int[] ints = main.sumPrefixScores(words);
        System.out.println(ints);
    }
    public int[] sumPrefixScores(String[] words) {
        int[]ans = new int[words.length];
        DictTree dictTree = new DictTree();
        for (int i = 0; i < words.length; i++) {
            dictTree.addString(dictTree,words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            ans[i] = dictTree.getCnt(dictTree,words[i]);
        }
        return ans;
    }
    
    
}

class DictTree{
    DictTree[] nodes = new DictTree[26];
    int cnt = 0;
    boolean closed;

    void addString(DictTree root, String str){
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i)-'a';
            DictTree node = root.nodes[index];
            if (node==null){
                node = new DictTree();
                node.cnt=1;
                root.nodes[index]  = node;
            }else {
                node.cnt+=1;
            }
            root = node;
        }
    }
    int  getCnt(DictTree root, String str){
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i)-'a';
            DictTree node = root.nodes[index];
            //System.out.println(node.cnt);
            root = node;
            cnt+=node.cnt;
        }
        return cnt;
    }
}