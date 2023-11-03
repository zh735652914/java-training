package leetcode;

/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area,
called the "root." Besides the root, each house has one and only one parent house. After a tour,
the smart thief realized that "all houses in this place forms a binary tree".
It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */


//自己写的感觉是智障,看了Discuss后才会写
class HouseRobberIIISolution {
    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[2];
        int[] L = dfs(root.left);
        int[] R = dfs(root.right);
        int[] ans = new int[2];
        ans[0] = root.val + L[1] + R[1];
        ans[1] = Math.max(L[0], L[1]) + Math.max(R[0], R[1]);
        return ans;
    }
}

public class HouseRobberIII {
    public static void main(String[] args) {
//        String[] nodes = {"3", "4", "5", "1", "3", "null", "1" };
//        String[] nodes = {"3", "2", "3", "null", "3", "null", "1" };
        String[] nodes = {"4", "1", "null", "2", "null", "3" };//7
        TreeNode root = new BuildTree().LevelBuild(nodes);
        System.out.println(new HouseRobberIIISolution().rob(root));
    }
}
