package SwordRefersToOffer;


import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
题目描述
从上往下打印出二叉树的每个节点，同层节点从左至右打印。

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
 */

/*
二叉树都忘了太多了，建树，打印都忘了。。。。。

!!!!!!!!!!!!!!!!!!!!!!!!!!!!建树有问题，遍历（PrintBinaryTreeSolution）没问题!!!!!!!!!!!!!!!!!!!!
 */
class PrintBinaryTreeSolution {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp.left != null) queue.offer(tmp.left);
            if (tmp.right != null) queue.offer(tmp.right);
            ans.add(tmp.val);
        }
        return ans;
    }


}

public class PrintBinaryTree {
    public static void main(String[] args) {
        //建立二叉树，有问题
//        int[] nums = {10, 6, 14, 4, 8, 12, 16};
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        int[] nums={};
        try {
            TreeNode root = new TreeNode(nums[0]);
            int pos = 1;
            root.left = build(nums, pos);
            pos++;
            root.right = build(nums, pos);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("请输入正确的数组，长度要求大于3");
        }
        TreeNode root = new TreeNode(nums[0]);
        root.left = build(nums, 1);
        root.right = build(nums, 2);

        PrintBinaryTreeSolution PBTS = new PrintBinaryTreeSolution();
        System.out.println(PBTS.PrintFromTopToBottom(root));

    }

    public static TreeNode build(int[] nums, int pos) {
        if (pos >= nums.length) return null;
        TreeNode p = new TreeNode(nums[pos]);
//        pos++;
        p.left = build(nums, ++pos);
//        pos++;
        p.right = build(nums, ++pos);
        return p;
    }

}
