package Beijing;
/*
https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */

public class connect {
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

    static class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }
            if (root.left != null) {
                root.left.next = root.right;
                // 因为是完全二叉树，左子树没有则代表右子树也没有
                if (root.next != null) {
                    root.right.next = root.next.left;
                }
            }
            connect(root.left);
            connect(root.right);
            return root;
        }
    }

    public static void main(String[] args) {
        System.out.println("这题需要题目给的node结点重新建立完全二叉树！");
    }
}
