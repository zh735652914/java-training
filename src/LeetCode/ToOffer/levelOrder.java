package LeetCode.ToOffer;
/*
面试题32 - I. 从上到下打印二叉树
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。



例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回：

[3,9,20,15,7]


提示：

节点总数 <= 1000
通过次数3,160提交次数4,793
 */


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

//这个方法没想到。。。。
public class levelOrder {
    static class Solution {
        public int[] levelOrder(TreeNode root) {
            if (root == null) return new int[]{};
            List<Integer> list = new LinkedList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            int[] ans = new int[list.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = new buildTree.levelBuild().buildTree(scanner.nextLine().split(","));
        int[] ans = new Solution().levelOrder(root);
        for (int x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
