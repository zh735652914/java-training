package nowcoder;
/*
 牛客题霸-名企高频面试题
找到搜索二叉树中两个错误的节点
时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 256M，其他语言512M 热度指数：979
本题知识点： 树 dfs
 算法知识视频讲解
题目描述
一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树，请按升序输出这两个错误节点的值。(每个节点的值各不相同)
示例1
输入
复制
{1,2,3}
输出
复制
[1,2]
备注:
1 \leq n \leq 5 \times 10^51≤n≤5×10
5

说明：本题目包含复杂数据结构TreeNode，点此查看相关信息
 */

import java.util.LinkedList;
import java.util.Queue;

public class findError {
    static class buildTree {
        public TreeNode mkTree(String s) {
            s = s.substring(1, s.length() - 1);
            String[] nodes = s.split(",");
            TreeNode root = mkNode(nodes, 0);
            int index = 1;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                cur.left = mkNode(nodes, index++);
                cur.right = mkNode(nodes, index++);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            return root;
        }

        private TreeNode mkNode(String[] nodes, int index) {
            if (index < 0 || index >= nodes.length || nodes[index].equals("#")) {
                return null;
            }
            return new TreeNode(Integer.parseInt(nodes[index]));
        }
    }

    static public class Solution {
        /**
         * @param root TreeNode类 the root
         * @return int整型一维数组
         */
        int[] ans;
        int last;

        public int[] findError(TreeNode root) {
            ans = new int[2];
            last = Integer.MIN_VALUE;
            backtrack(root);
            return ans;
        }

        private void backtrack(TreeNode root) {
            if (root == null) {
                return;
            }
            backtrack(root.left);
            if (root.val < last) {
                ans[0] = root.val;
                ans[1] = last;
            } else {
                last = root.val;
            }
            backtrack(root.right);
        }
    }

    public static void main(String[] args) {
        String nodes = "{34,20,38,3,29,35,44,2,4,24,30,#,37,42,45,1,#,#,12,23,26,#,32,36,#,40,21,#,#,#,#,5,15,43,#,25,28,31,33,#,#,39,41,#,#,#,8,14,18,#,22,#,#,27,#,#,#,#,#,#,#,#,#,6,10,13,#,16,19,#,#,#,#,#,7,9,11,#,#,#,17}";
        TreeNode root = new buildTree().mkTree(nodes);
        int[] ans = new Solution().findError(root);
        for (int x : ans) {
            System.out.print(x + ",");
        }
    }
}
