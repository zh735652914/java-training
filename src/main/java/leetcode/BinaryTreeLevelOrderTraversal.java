package leetcode;
/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */

import java.util.LinkedList;
import java.util.List;

class BinaryTreeLevelOrderTraversalSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        List<Integer> aAns = new LinkedList<>();
        aAns.add(root.val);
        ans.add(aAns);
        backtrack(ans, root, 1);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, TreeNode root, int level) {
        if (root == null) return;
        if (level < ans.size()) {
            if (root.left != null) ans.get(level).add(root.left.val);
            if (root.right != null) ans.get(level).add(root.right.val);
        } else {
            List<Integer> aAns = new LinkedList<>();
            if (root.left != null) aAns.add(root.left.val);
            if (root.right != null) aAns.add(root.right.val);
            if (!aAns.isEmpty()) ans.add(aAns);
        }
        backtrack(ans, root.left, level + 1);
        backtrack(ans, root.right, level + 1);
    }
}

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        String[] s = {"3", "9", "20", "null", "null", "15", "7"};
        BuildTree BT = new BuildTree();
        TreeNode root = BT.LevelBuild(s);
        BinaryTreeLevelOrderTraversalSolution BTOT = new BinaryTreeLevelOrderTraversalSolution();
        System.out.println(BTOT.levelOrder(root));
    }
}
