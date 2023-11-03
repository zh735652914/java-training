package beijing;
/*
https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 这题很简单
public class NaryTreeLevelOrderTraversal {
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

    static class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ans = new LinkedList<>();
            Queue<Node> queue = new LinkedList<>();
            if (root == null) {
                return ans;
            }
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new LinkedList<>();
                int size = queue.size();
                while (size > 0) {
                    Node cur = queue.poll();
                    level.add(cur.val);
                    size--;
                    for (Node child : cur.children) {
                        queue.offer(child);
                    }
                }
                ans.add(level);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"1", "null", "3", "2", "4", "null", "5", "6"};
        Node root = BuildTree(nodes);
        System.out.println(new Solution().levelOrder(root));
    }

    private static Node BuildTree(String[] nodes) {
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(nodes[0]), new LinkedList<>());
        queue.offer(root);
        int index = 2;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            while (index < nodes.length && !nodes[index].equals("null")) {
                Node child = new Node(Integer.parseInt(nodes[index]), new LinkedList<>());
                cur.children.add(child);
                queue.offer(child);
                index++;
            }
            index++;
        }
        return root;
    }
}
