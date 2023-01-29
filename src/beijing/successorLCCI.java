package beijing;
/*
https://leetcode.cn/problems/successor-lcci/
 */

public class successorLCCI {
    // 官方的解析，还是官方的快
    static class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (p.right != null) {
                TreeNode cur = p.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                return cur;
            }
            TreeNode cur = root;
            TreeNode successor = null;
            while (cur != null) {
                if (cur.val > p.val) {
                    successor = cur;
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
            return successor;
        }
    }


    // 两年前自己写的方法
    static class Solution1 {
        boolean flag = false;
        TreeNode ans = null;

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (root == null) {
                return null;
            }
            inorderSuccessor(root.left, p);
            if (flag) {
                ans = root;
                flag = false;
            }
            if (root == p) {
                flag = true;
            }
            inorderSuccessor(root.right, p);
            return ans;
        }
    }

    // 自己居然调试了三遍
    static class Solution0 {
        TreeNode next;
        TreeNode pre;

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            next = null;
            pre = null;
            inOrder(root, p);
            return next;
        }

        private void inOrder(TreeNode root, TreeNode p) {
            if (root == null) {
                return;
            }
            inOrder(root.left, p);
            if (pre == p) {
                next = root;
                pre = null;
                return;
            }
            pre = root;
            inOrder(root.right, p);
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"5", "3", "6", "2", "4", "null", "null", "1"};
        int pVal = 1;
//        String[] nodes = {"2", "null", "3"};
//        int pVal = 2;
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        TreeNode p = findNode(root, pVal);
        TreeNode next = new Solution().inorderSuccessor(root, p);
        if (next == null) {
            System.out.println("null");
        } else {
            System.out.println(next.val);
        }
    }

    private static TreeNode findNode(TreeNode root, int pVal) {
        if (root == null) {
            return null;
        }
        if (root.val == pVal) {
            return root;
        }
        TreeNode left = findNode(root.left, pVal);
        TreeNode right = findNode(root.right, pVal);
        return left != null ? left : right;
    }
}
