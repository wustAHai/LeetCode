package contest.Th60;

import java.util.ArrayList;
import java.util.List;

public class L5848 {
    class LockingTree {
        List<Node> tree;
        public LockingTree(int[] parent) {
            tree = new ArrayList<>();
            for (int i = 0; i < parent.length; i++) {
                Node node = new Node();
                node.parent = parent[i];
                tree.add(node);
            }
            for (int i = 0; i < parent.length; i++) {
                if (parent[i]!=-1){
                    Node node = tree.get(parent[i]);
                    node.children.add(i);
                }
            }
        }

        public boolean lock(int num, int user) {
            Node node = tree.get(num);
            if (node.status==0){
                node.status =1;
                node.user = user;
                return true;
            }
            return false;
        }

        public boolean unlock(int num, int user) {
            Node node = tree.get(num);
            if (node.status==1&&node.user==user){
                node.status= 0;
                return true;
            }
            return false;
        }

        public boolean upgrade(int num, int user) {
            Node node = tree.get(num);
            boolean child = false;
            boolean parent = false;
            child = findChildren(node);
            parent = findParent(node);
            if (node.status==0&&child&&parent){
                setChildren(node);
                lock(num,user);
                return true;
            }
            return false;
        }

        private void setChildren(Node node) {
            ArrayList<Integer> children = node.getChildren();
            for (int i = 0; i < children.size(); i++) {
                Node node1 = tree.get(children.get(i));
                node1.status=0;
                setChildren(node1);
            }
        }

        private boolean findParent(Node node) {
            while (node.parent!=-1){
                 node = tree.get(node.parent);
                if (node.status==1){
                    return false;
                }
            }
            return true;
        }

        private boolean findChildren(Node node) {
            ArrayList<Integer> children = node.getChildren();
            boolean flag  = false;
            for (int i = 0; i < children.size(); i++) {
                Node node1 = tree.get(children.get(i));
                if (node1.status==1){
                    return true;
                }
                flag = flag||findChildren(node1);
                if (flag){
                    return true;
                }
            }
            return flag;
        }

        class Node{
            int status;
            int user;
            int parent;
            ArrayList<Integer> children = new ArrayList<>();

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getUser() {
                return user;
            }

            public void setUser(int user) {
                this.user = user;
            }

            public int getParent() {
                return parent;
            }

            public void setParent(int parent) {
                this.parent = parent;
            }

            public ArrayList getChildren() {
                return children;
            }

            public void setChildren(ArrayList children) {
                this.children = children;
            }
        }
    }
}
