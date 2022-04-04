package idea;


import java.util.*;

public class Haff {
    //0 左  1 右
    public static class Node{
        char ch;
        int weight;
        Node left;
        Node right;

        public Node() {
        }

        public Node(char ch, int weight) {
            this.ch = ch;
            this.weight = weight;
        }
    }

    public Node constructHaff(List<Node> nodes){
        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight- o2.weight;
            }
        });
        for (Node node : nodes) {
            queue.offer(node);
        }
        while (queue.size()>1){
            Node  left = queue.poll();
            Node  right = queue.poll();
            Node node = new Node();
            node.weight = left.weight+ right.weight;
            node.left =left;
            node.right =right;
            queue.offer(node);
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        Haff haff = new Haff();
        ArrayList<Node>  nodes = new ArrayList<>();
        nodes.add(new Node('a',1));
        nodes.add(new Node('b',2));
        nodes.add(new Node('c',3));
        nodes.add(new Node('d',4));
        Node node = haff.constructHaff(nodes);
    }
}
