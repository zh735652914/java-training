package leetcode.tooffer;
/*
面试题32 - III. 从上到下打印二叉树 III
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。



例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [20,9],
  [15,7]
]


提示：

节点总数 <= 1000
通过次数2,650提交次数4,374
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class levelOrderIII {
    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new LinkedList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if (root == null) return ans;
            queue.offer(root);
            int level = 0;
            while (!queue.isEmpty()) {
                int count = queue.size();
                List<Integer> aLevel = new LinkedList<>();
                Stack<TreeNode> stack = new Stack<>();
                for (int i = 0; i < count; i++) {
                    TreeNode node = queue.poll();
                    aLevel.add(node.val);
                    if (level % 2 == 1) {
                        if (node.right != null) stack.push(node.right);
                        if (node.left != null) stack.push(node.left);
                    } else {
                        if (node.left != null) stack.push(node.left);
                        if (node.right != null) stack.push(node.right);
                    }
                }
                while (!stack.isEmpty()) {
                    queue.offer(stack.pop());
                }
                ans.add(aLevel);
                level++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = new buildTree.levelBuild().buildTree(scanner.nextLine().split(","));
        System.out.println(new Solution().levelOrder(root));
        System.out.println();
    }
}
