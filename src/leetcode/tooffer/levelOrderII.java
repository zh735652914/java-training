package leetcode.tooffer;
/*
面试题32 - II. 从上到下打印二叉树 II
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。



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
  [9,20],
  [15,7]
]


提示：

节点总数 <= 1000
注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/

通过次数3,326提交次数4,634
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class levelOrderII {
    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> ans = new LinkedList<>();
            if (root == null) return ans;
            queue.offer(root);
            while (!queue.isEmpty()) {
                int count = queue.size();
                List<Integer> aLevel = new LinkedList<>();
                for (int i = 0; i < count; i++) {
                    TreeNode node = queue.poll();
                    aLevel.add(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);

                }
                ans.add(aLevel);
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
