package swordreferstooffer;
/*
题目描述
输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
(注意: 在返回值的list中，数组长度大的数组靠前)
 */
/*
不会。。。
不是自己写的。。。
 */


import java.util.ArrayList;

class BinaryTreePathOfValueSolution {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> aAns = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return ans;
        aAns.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            ans.add(new ArrayList<Integer>(aAns));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        aAns.remove(aAns.size() - 1);
        return ans;
    }

}

public class BinaryTreePathOfValue {
    public static void main(String[] args) {
        int target = 10;
        BinaryTreePathOfValueSolution BTPV = new BinaryTreePathOfValueSolution();

    }
}
