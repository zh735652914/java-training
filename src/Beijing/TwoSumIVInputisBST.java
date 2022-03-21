package Beijing;
/*
https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 */

import java.util.*;

public class TwoSumIVInputisBST {
    // 这个最快
    static class Solution {
        private Deque<TreeNode> L;
        private Deque<TreeNode> R;

        public boolean findTarget(TreeNode root, int k) {
            L = new ArrayDeque<>();
            R = new ArrayDeque<>();
            TreeNode left = root;
            TreeNode right = root;
            L.offerLast(left);
            while (left.left != null) {
                left = left.left;
                L.offerLast(left);
            }
            R.offerLast(right);
            while (right.right != null) {
                right = right.right;
                R.offerLast(right);
            }
            while (left != right) {
                int sum = left.val + right.val;
                if (sum == k) {
                    return true;
                } else if (sum < k) {
                    left = getLeft();
                } else {
                    right = getRight();
                }
            }
            return false;
        }

        private TreeNode getLeft() {
            TreeNode cur = L.pollLast();
            TreeNode node = cur.right;
            while (node != null) {
                L.offerLast(node);
                node = node.left;
            }
            return cur;
        }

        private TreeNode getRight() {
            TreeNode cur = R.pollLast();
            TreeNode node = cur.left;
            while (node != null) {
                R.offerLast(node);
                node = node.right;
            }
            return cur;
        }
    }


    // 用stack写居然慢一些
    static class Solution2 {
        private Stack<TreeNode> L;
        private Stack<TreeNode> R;

        public boolean findTarget(TreeNode root, int k) {
            L = new Stack<>();
            R = new Stack<>();
            TreeNode left = root;
            TreeNode right = root;
            L.push(left);
            while (left.left != null) {
                left = left.left;
                L.push(left);
            }
            R.push(right);
            while (right.right != null) {
                right = right.right;
                R.push(right);
            }
            while (left != right) {
                int sum = left.val + right.val;
                if (sum == k) {
                    return true;
                } else if (sum < k) {
                    left = getLeft();
                } else {
                    right = getRight();
                }
            }
            return false;
        }

        private TreeNode getLeft() {
            TreeNode cur = L.pop();
            TreeNode node = cur.right;
            while (node != null) {
                L.push(node);
                node = node.left;
            }
            return cur;
        }

        private TreeNode getRight() {
            TreeNode cur = R.pop();
            TreeNode node = cur.left;
            while (node != null) {
                R.push(node);
                node = node.right;
            }
            return cur;
        }
    }

    // 这个效率不高
    static class Solution0 {
        private final Set<Integer> set = new HashSet<>();

        public boolean findTarget(TreeNode root, int k) {
            if (root == null) {
                return false;
            }
            if (set.contains(k - root.val)) {
                return true;
            }
            set.add(root.val);
            return findTarget(root.left, k) || findTarget(root.right, k);
        }
    }

    public static void main(String[] args) {
//        String[] nodes = {"5", "3", "6", "2", "4", "null", "7"};
//        int k = 28;
        String[] nodes = {"2", "1", "3"};
        int k = 1;
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().findTarget(root, k));
    }
}
