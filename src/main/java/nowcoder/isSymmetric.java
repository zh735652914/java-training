package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：18089
本题知识点： 树 dfs bfs
 算法知识视频讲解
题目描述
给定一棵二叉树，判断琪是否是自身的镜像（即：是否对称）
例如：下面这棵二叉树是对称的
     1
    /  \
  2    2
 / \    / \
3 4  4  3
下面这棵二叉树不对称。
    1
    / \
  2   2
    \    \
    3    3
备注：
希望你可以用递归和迭代两种方法解决这个问题
示例1
输入
复制
{1,2,2}
输出
复制
true
示例2
输入
复制
{1,2,3,3,#,2,#}
输出
复制
false
说明：本题目包含复杂数据结构TreeNode，点此查看相关信息
 */

import java.util.LinkedList;
import java.util.Queue;

public class isSymmetric {
    static public class Solution {
        /**
         * @param root TreeNode类
         * @return bool布尔型
         */
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSame(root.left, root.right);
        }

        private boolean isSame(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return true;
            }
            if (root1 == null || root2 == null) {
                return false;
            }
            if (root1.val != root2.val) {
                return false;
            }
            return isSame(root1.left, root2.right) && isSame(root1.right, root2.left);
        }
    }

    static class buildTree {
        public TreeNode build_Tree(String s) {
            s = s.substring(1, s.length() - 1);
            String[] nodes = s.split(",");
            TreeNode root = mkNodes(nodes, 0);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int index = 1;
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                cur.left = mkNodes(nodes, index++);
                cur.right = mkNodes(nodes, index++);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            return root;
        }

        private TreeNode mkNodes(String[] nodes, int index) {
            if (index < 0 || index >= nodes.length || nodes[index].equals("#")) {
                return null;
            }
            return new TreeNode(Integer.parseInt(nodes[index]));
        }
    }

    public static void main(String[] args) {
        String nodes = "{1,2,2,#,3,3}";
        TreeNode root = new buildTree().build_Tree(nodes);
        System.out.println(new Solution().isSymmetric(root));
    }
}
