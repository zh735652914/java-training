package leetcode;
/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values.
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */
//自己没写出来！但是很重要！！！！

import java.util.LinkedList;
import java.util.List;

class BinaryTreeLevelOrderTraversalIISolution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        backtrack(ans, root, 0);
//        System.out.println("deep= " + backtrack2(ans, root, 0));
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, TreeNode root, int level) {
        if (root == null) return;
        if (level >= ans.size()) {
            ans.add(0, new LinkedList<>());
        }
        backtrack(ans, root.left, level + 1);
        backtrack(ans, root.right, level + 1);
        ans.get(ans.size() - level - 1).add(root.val);
    }
}

public class BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {
//        String[] s = {"3", "9", "20", "null", "null", "15", "7"};
        String[] s = {"3", "9", "20", "15", "null", "7", "null"};
        BuildTree buildTree = new BuildTree();
        TreeNode root = buildTree.LevelBuild(s);
        BinaryTreeLevelOrderTraversalIISolution binaryTreeLevelOrderTraversalIISolution = new BinaryTreeLevelOrderTraversalIISolution();
        System.out.println(binaryTreeLevelOrderTraversalIISolution.levelOrderBottom(root));
    }
}
