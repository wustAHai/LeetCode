package mid;

/**
 * @author chenz at 10:52 on 2022/6/18 .
 */
public class JZII029 {
    public Node insert(Node head, int insertVal) {
        if (head == null){
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node p = head;
        Node q = p.next;
        Node insert = new Node(insertVal);
        if (p==q){
            p.next = insert;
            insert.next = q;
        }
        while (q.val == p.val){
            q=q.next;
            if (q==p){
                insert.next = p.next;
                p.next = insert;
                return head;
            }
        }
        q = p.next;
        while (true){
            if (p.val<=q.val){
                if (p.val<=insertVal&&insertVal<=q.val){
                    p.next = insert;
                    insert.next = q;
                    break;
                }
            }else {
                if (insertVal>=p.val||insertVal<=q.val){
                    p.next = insert;
                    insert.next = q;
                    break;
                }
            }
            q = q.next;
            p = p.next;
        }
        return head;
    }
    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _next) {
            val = _val;
            next = _next;
        }
    }
}


