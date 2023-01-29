package beijing;
/*
https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
 */

import java.util.LinkedList;
import java.util.Queue;

public class populatingNextRightPointersinEachNode_116_topInterviewList {
    // Definition for a Node.
    static class Node {
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

    // 评论的写法
    static class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            if (root.left != null) {
                root.left.next = root.right;
                if (root.next != null) {
                    root.right.next = root.next.left;
                }
            }
            connect(root.left);
            connect(root.right);
            return root;
        }
    }

    // 自己写的，效率不高
    static class Solution0 {
        public Node connect(Node root) {
            Queue<Node> queue = new LinkedList<>();
            if (root != null) {
                queue.offer(root);
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                Node last = queue.poll();
                if (last.left != null) {
                    queue.offer(last.left);
                }
                if (last.right != null) {
                    queue.offer(last.right);
                }
                while (--size > 0) {
                    Node cur = queue.poll();
                    last.next = cur;
                    last = cur;
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5, 6, 7};
        Node root = new Node(nodes[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (index < nodes.length) {
            int size = queue.size();
            while (size-- > 0) {
                Node cur = queue.poll();
                if (index >= nodes.length) {
                    break;
                }
                cur.left = new Node(nodes[index++]);
                queue.offer(cur.left);
                if (index >= nodes.length) {
                    break;
                }
                cur.right = new Node(nodes[index++]);
                queue.offer(cur.right);
            }
        }
        Node ans = new Solution().connect(root);
        while (ans != null) {
            Node head = ans;
            while (head != null) {
                System.out.print(head.val + "->");
                head = head.next;
            }
            System.out.println("#");
            ans = ans.left;
        }
    }
}
