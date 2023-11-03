package beijing;
/*
https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 */

public class connectII {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    // 自己没想出来，只想说，牛逼
    static class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }
            if (root.left != null && root.right != null) {
                root.left.next = root.right;
            }
            if (root.left != null && root.right == null) {
                root.left.next = getNext(root.next);
            }
            if (root.right != null) {
                root.right.next = getNext(root.next);
            }
            connect(root.right);
            connect(root.left);
            return root;
        }

        private Node getNext(Node root) {
            if (root == null) {
                return root;
            }
            if (root.left != null) {
                return root.left;
            }
            if (root.right != null) {
                return root.right;
            }
            if (root.next != null) {
                return getNext(root.next);
            }
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println("这题需要题目给的node结点重新建立完全二叉树！");
    }
}
