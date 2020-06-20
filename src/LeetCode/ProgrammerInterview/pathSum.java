package LeetCode.ProgrammerInterview;
/*
面试题 04.12. 求和路径
给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。
注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

3
解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
提示：

节点总数 <= 10000
通过次数3,451提交次数7,147
 */


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//不会写。。。。这题有点东西,看了题解，其实还是不太懂
public class pathSum {
    static class Solution {
        public int pathSum(TreeNode root, int sum) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            return backtrack(root, sum, map, 0);
        }

        private int backtrack(TreeNode root, int sum, Map<Integer, Integer> map, int currSum) {
            if (root == null) return 0;
            currSum += root.val;
            int count = map.getOrDefault(currSum - sum, 0);
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
            count += backtrack(root.left, sum, map, currSum);
            count += backtrack(root.right, sum, map, currSum);
            map.put(currSum, map.getOrDefault(currSum, 0) - 1);
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nodes = {"5", "4", "8", "11", "null", "13", "4", "7", "2", "null", "null", "5", "1"};
        TreeNode root = new BuildTree().level_build_tree(nodes);
        int sum = scanner.nextInt();
        System.out.println(new Solution().pathSum(root, sum));
    }
}
