package mid;

import easy.TreeNode;

import java.util.*;

/**
 * @author chenz at 20:32 on 2022/9/5 .
 */
public class L652 {
    Map<String,Pair<TreeNode,Integer>> seen = new HashMap<>();
    Set<TreeNode> repeat = new HashSet<>();
    int idx = 0;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        List<TreeNode> ans = new ArrayList<>(repeat);
        return ans;
    }

    int dfs(TreeNode root){
        if (root==null){
            return 0;
        }
        int[] val = new int[]{root.val,dfs(root.left),dfs(root.right)};
        String seq  = Arrays.toString(val);
        if (seen.containsKey(seq)){
            Pair<TreeNode, Integer> pair = seen.get(seq);
            repeat.add(pair.getKey());
            return pair.getVal();
        }else {
            seen.put(seq,new Pair<>(root,++idx));
        }
        return idx;
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