package nowcoder;
/*
 牛客题霸-名企高频面试题
二叉树根节点到叶子节点和为指定值的路径 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：25696
本题知识点： 树 dfs
 算法知识视频讲解
题目描述
给定一个二叉树和一个值\ sum sum，请找出所有的根节点到叶子节点的节点值之和等于\ sum sum 的路径，
例如：
给出如下的二叉树，\ sum=22 sum=22，

返回
[
[5,4,11,2],
[5,8,9]
]
示例1
输入
复制
{1,2},1
输出
复制
[]
示例2
输入
复制
{1,2},3
输出
复制
[[1,2]]
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class pathSum {
    static public class Solution {
        /**
         * @param root TreeNode类
         * @param sum  int整型
         * @return int整型ArrayList<ArrayList <>>
         */
        ArrayList<ArrayList<Integer>> ans;

        public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
            ans = new ArrayList<>();
            findPath(root, sum, 0, new ArrayList<>());
            return ans;
        }

        private void findPath(TreeNode root, int target, int sum, ArrayList<Integer> list) {
            if (root == null) {
                return;
            }
            sum += root.val;
            list.add(root.val);
            if (sum == target && root.left == null && root.right == null) {
                ans.add(list);
                return;
            }
            findPath(root.left, target, sum, new ArrayList<>(list));
            findPath(root.right, target, sum, new ArrayList<>(list));
        }
    }

    static class mkTree {
        public TreeNode buildTree(String s) {
            s = s.substring(1, s.length() - 1);
            String[] nodes = s.split(",");
            TreeNode root = mkNode(nodes, 0);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int index = 1;
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            TreeNode root = new mkTree().buildTree(scanner.nextLine());
            System.out.println(new Solution().pathSum(root, scanner.nextInt()));
        }
    }
}
