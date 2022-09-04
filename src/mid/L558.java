package mid;

/**
 * @author chenz at 19:20 on 2022/7/15 .
 */
public class L558 {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf&&!quadTree1.val){
            return quadTree2;
        }
        if (quadTree2.isLeaf&&!quadTree2.val){
            return quadTree1;
        }
        if (quadTree1.isLeaf){
            return quadTree1;
        }
        if (quadTree2.isLeaf){
            return quadTree2;
        }
        Node ans = new Node();
        ans.bottomLeft = intersect(quadTree1.bottomLeft,quadTree2.bottomLeft);
        ans.bottomRight = intersect(quadTree1.bottomRight,quadTree2.bottomRight);
        ans.topLeft = intersect(quadTree1.topLeft,quadTree2.topLeft);
        ans.topRight = intersect(quadTree1.topRight,quadTree2.topRight);
        if (ans.bottomRight.isLeaf&&ans.bottomLeft.isLeaf&&ans.topRight.isLeaf&&ans.topLeft.isLeaf){
            if (ans.bottomRight.val==ans.bottomLeft.val&&ans.topLeft.val==ans.topRight.val&&ans.topLeft.val==ans.bottomRight.val){
                ans.isLeaf = true;
                ans.val = ans.bottomRight.val;
                ans.topLeft = null;
                ans.bottomLeft = null;
                ans.topRight = null;
                ans.bottomRight = null;
            }
        }
        return ans;
    }

}

