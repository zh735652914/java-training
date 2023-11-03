package nowcoder;
/*
 牛客题霸-名企高频面试题
将升序数组转化为平衡二叉搜索树 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：16807
本题知识点： 树 dfs
 算法知识视频讲解
题目描述
给出一个升序排序的数组，将其转化为平衡二叉搜索树（BST）.
示例1
输入
复制
[-1,0,1,2]
输出
复制
{1,0,2,-1}
说明：本题目包含复杂数据结构TreeNode，点此查看相关信息
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class sortedArrayToBST {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static public class Solution {
        /**
         * @param num int整型一维数组
         * @return TreeNode类
         */
        public TreeNode sortedArrayToBST(int[] num) {
            return backtrack(num, 0, num.length - 1);
        }

        private TreeNode backtrack(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = (start + end + 1) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = backtrack(nums, start, mid - 1);
            root.right = backtrack(nums, mid + 1, end);
            return root;
        }
    }

    static class TreeToList {
        public List<List<Integer>> TreeList(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<List<Integer>> list = new LinkedList<>();
            if (root == null) {
                return list;
            }
            while (!queue.isEmpty()) {
                int len = queue.size();
                List<Integer> aLevel = new LinkedList<>();
                for (int i = 0; i < len; i++) {
                    TreeNode cur = queue.poll();
                    aLevel.add(cur.val);
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                list.add(aLevel);
            }
            return list;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3};
        TreeNode root = new Solution().sortedArrayToBST(nums);
        System.out.println(new TreeToList().TreeList(root));
    }
}
