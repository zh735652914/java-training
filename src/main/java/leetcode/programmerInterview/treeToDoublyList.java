package leetcode.programmerInterview;
/*
剑指 Offer 36. 二叉搜索树与双向链表
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。



为了让您更好地理解问题，以下面的二叉搜索树为例：







我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。

下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。







特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。



注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/

注意：此题对比原题有改动。

通过次数28,518提交次数44,549
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class treeToDoublyList {
    static class Solution {
        Node pre, head;

        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            head = new Node(-1);
            pre = null;
            backtrack(root);
            head.right.left = pre;
            pre.right = head.right;
            return head.right;
        }

        private void backtrack(Node root) {
            if (root == null) {
                return;
            }
            backtrack(root.left);
            if (pre != null) {
                pre.right = root;
            } else {
                head.right = root;
            }
            root.left = pre;
            pre = root;
            backtrack(root.right);
        }
    }

    static class Solution0 {
        Queue<Node> queue;

        public Node treeToDoublyList(Node root) {
            Node head = new Node(-1);
            if (root == null) {
                return head;
            }
            queue = new LinkedList<>();
            backtrack(root);
            Node p = head;
            while (!queue.isEmpty()) {
                p.right = queue.poll();
                Node pre = p;
                p = p.right;
                p.left = pre;
            }
            head.right.left = p;
            p.right = head.right;
            return head;
        }

        private void backtrack(Node root) {
            if (root == null) {
                return;
            }
            backtrack(root.left);
            queue.offer(root);
            backtrack(root.right);
        }
    }

    static class buildTree {
        public Node buildTree(String[] nodes) {
            if (nodes == null || nodes.length == 0) return null;
            int[] nums = new int[nodes.length];
            for (int i = 0; i < nums.length; i++) {
                if (nodes[i].equals("null")) {
                    nums[i] = Integer.MIN_VALUE;
                } else {
                    nums[i] = Integer.parseInt(nodes[i]);
                }
            }
            return backtrack(0, nums, 0);
        }

        private Node backtrack(int deep, int[] nums, int pos) {
            if (pos >= nums.length) return null;
            if (nums[pos] == Integer.MIN_VALUE) return null;
            Node root = new Node(nums[pos]);
            int left = (int) ((Math.pow(2, deep + 1) - 1) + 2 * (pos - (Math.pow(2, deep) - 1)));
            root.left = backtrack(deep + 1, nums, left);
            root.right = backtrack(deep + 1, nums, left + 1);
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Node root = new buildTree().buildTree(scanner.nextLine().split(","));
            Node head = new Solution().treeToDoublyList(root);
            Node first = head.right;
            if (first == null) {
                System.out.println("null");
                break;
            }
            Node p = first.right;
            System.out.print(first.val + "->");
            while (p != first) {
                System.out.print(p.val + "->");
                p = p.right;
            }
            System.out.println();

            p = p.left;
            while (p != first) {
                System.out.print(p.val + "<-");
                p = p.left;
            }
            System.out.println(p.val + "<-");
        }
    }
}
