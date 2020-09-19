package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：481701
本题知识点： 分治
 算法知识视频讲解
题目描述
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */

import java.util.LinkedList;
import java.util.Queue;

public class Convert {
    static public class Solution {

        public TreeNode Convert(TreeNode pRootOfTree) {
            inOrder(pRootOfTree, null);

            while (pRootOfTree != null && pRootOfTree.left != null) {
                pRootOfTree = pRootOfTree.left;
            }
            return pRootOfTree;
        }

        private TreeNode inOrder(TreeNode root, TreeNode per) {
            if (root == null) {
                return null;
            }
            if (root.left != null) {
                per = inOrder(root.left, per);
            }

            root.left = per;
            if (per != null) {
                per.right = root;
            }

            per = root;
            if (root.right != null) {
                per = inOrder(root.right, per);
            }
            return per;
        }
    }

    static class buildTree {
        public TreeNode buildtree(String s) {
            s = s.substring(1, s.length() - 1);
            String[] nodes = s.split(",");
            if (nodes.length == 0) {
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = mkNode(nodes[0]);
            queue.offer(root);
            TreeNode p;
            int index = 1;
            while (!queue.isEmpty()) {
                p = queue.poll();
                if (index < nodes.length) {
                    p.left = mkNode(nodes[index++]);
                }
                if (index < nodes.length) {
                    p.right = mkNode(nodes[index++]);
                }
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
            return root;
        }

        private TreeNode mkNode(String x) {
            if (x.equals("nulll")) {
                return null;
            }
            return new TreeNode(Integer.parseInt(x));
        }
    }

    public static void main(String[] args) {
        String nodes = "[10,6,14,4,8,12,16]";
        TreeNode root = new buildTree().buildtree(nodes);
        TreeNode ans = new Solution().Convert(root);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.right;
        }
    }
}
