package beijing;
/*
https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreePostorderTraversal {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static class BuildTree {
        public Node LevelBuildTree(String[] nodes) {
            Node root = null;
            if (nodes.length < 1) {
                return root;
            }
            root = new Node(Integer.parseInt(nodes[0]));
            List<Node> children = new LinkedList<>();
            Queue<Node> parents = new LinkedList<>();
            parents.add(root);
            for (int i = 2; i < nodes.length; i++) {
                int size = parents.size();
                for (int j = 0; j < size; j++) {
                    while (i < nodes.length && !nodes[i].equals("null")) {
                        Node ch = new Node(Integer.parseInt(nodes[i]));
                        children.add(ch);
                        parents.offer(ch);
                        i++;
                    }
                    Node p = parents.poll();
                    p.children = children;
                    children = new LinkedList<>();
                }
            }
            return root;
        }
    }

    static class Solution {
        private List<Integer> ans;

        public List<Integer> postorder(Node root) {
            ans = new LinkedList<>();
            visit(root);
            return ans;
        }

        private void visit(Node root) {
            if (root == null) {
                return;
            }
            List<Node> children = root.children;
            if (children != null) {
                for (Node child : children) {
                    visit(child);
                }
            }
            ans.add(root.val);
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"1", "null", "3", "2", "4", "null", "5", "6"};
        Node root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().postorder(root));
    }
}
