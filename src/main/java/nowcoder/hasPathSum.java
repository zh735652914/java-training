package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：23970
本题知识点： 树 dfs
 算法知识视频讲解
题目描述
给定一个二叉树和一个值\ sum sum，判断是否有从根节点到叶子节点的节点值之和等于\ sum sum 的路径，
例如：
给出如下的二叉树，\ sum=22 sum=22，

返回true，因为存在一条路径 5\to 4\to 11\to 25→4→11→2的节点值之和为 22
示例1
输入
复制
{1,2},0
输出
复制
false
示例2
输入
复制
{1,2},3
输出
复制
true
 */

import java.util.LinkedList;
import java.util.Queue;

public class hasPathSum {
    static public class Solution {
        /**
         * @param root TreeNode类
         * @param sum  int整型
         * @return bool布尔型
         */
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            return isPath(root, sum, 0);
        }

        private boolean isPath(TreeNode root, int sum, int count) {
            if (root == null) {
                return false;
            }
            count += root.val;
            if (root.left == null && root.right == null) {
                return count == sum;
            }
            return isPath(root.left, sum, count) || isPath(root.right, sum, count);
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
            if (index < 0 || index >= nodes.length || nodes[index].equals("null")) {
                return null;
            }
            return new TreeNode(Integer.parseInt(nodes[index]));
        }
    }

    public static void main(String[] args) {
//        String nodes = "[5,4,8,1,11,null,9,null,null,2,7]";
        String nodes = "[1,2]";
        TreeNode root = new buildTree().build_Tree(nodes);
        int sum = 1;
        System.out.println(new Solution().hasPathSum(root, sum));
    }
}
