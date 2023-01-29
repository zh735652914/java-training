package leetcode.tooffer;
/*
面试题34. 二叉树中和为某一值的路径
输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。



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

[
   [5,4,11,2],
   [5,8,4,5]
]


提示：

节点总数 <= 10000
注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/

通过次数2,913提交次数5,388
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//输入的时候，注意建立树的问题，输入为 5,4,8,11,null,13,4,7,2,null,null,null,null,5,1
//才是正确的
public class pathSum {
    static class Solution {
        List<List<Integer>> ans;

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            ans = new ArrayList<>();
            if (root == null) return ans;
//            dfs(root, sum, 0, new LinkedList<>());
            List<Integer> path = new LinkedList<>();
            path.add(root.val);
            dfs(root, sum, root.val, path);
            return ans;
        }

        private void dfs(TreeNode root, int sum, int hasSum, List<Integer> path) {
            if (root.left == null && root.right == null) {
                if (sum == hasSum) {
                    ans.add(path);
                }
                return;
            }
            if (root.left != null) {
                path.add(root.left.val);
                dfs(root.left, sum, hasSum + root.left.val, new LinkedList<>(path));
                path.remove(path.size() - 1);
            }
            if (root.right != null) {
                path.add(root.right.val);
                dfs(root.right, sum, hasSum + root.right.val, new LinkedList<>(path));
                path.remove(path.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            TreeNode root = new buildTree.levelBuild().buildTree(scanner.nextLine().split(","));
            System.out.println(new Solution().pathSum(root, scanner.nextInt()));
        }
    }
}
