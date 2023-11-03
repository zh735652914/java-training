package leetcode;
/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreeZigzagLevelOrderTraversalSolution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<Integer> aAns = new ArrayList<>();
        aAns.add(root.val);
        ans.add(aAns);
        Stack<TreeNode> S = new Stack<>();
        S.push(root);
        backtrack(ans, 2, S);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, int level, Stack<TreeNode> S) {
        int n = S.size();
        if (n == 0) return;
        List<Integer> aAns = new ArrayList<>();
        Stack<TreeNode> S2 = new Stack<>();
        while (n > 0) {
            TreeNode root = S.pop();
            if (level % 2 == 1) {
                if (root.left != null) {
                    aAns.add(root.left.val);
                    S2.push(root.left);
                }
                if (root.right != null) {
                    aAns.add(root.right.val);
                    S2.push(root.right);
                }
            } else {
                if (root.right != null) {
                    aAns.add(root.right.val);
                    S2.push(root.right);
                }
                if (root.left != null) {
                    aAns.add(root.left.val);
                    S2.push(root.left);
                }
            }

            n--;
        }
        if (!aAns.isEmpty()) ans.add(aAns);
        backtrack(ans, level + 1, S2);
    }
}

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
//        String[] s = {"3", "9", "20", "null", "null", "15", "7"};
        String[] s = {"1", "2", "3", "4", "null", "null", "5"};
//        String[] s = {"0", "2", "4", "1", "null", "3", "-1", "5", "1", "null", "6", "null", "8"};//[[0],[4,2],[1,3,-1],[8,6,1,5]]
        BuildTree BT = new BuildTree();
        TreeNode root = BT.LevelBuild(s);
        BinaryTreeZigzagLevelOrderTraversalSolution BTZLO = new BinaryTreeZigzagLevelOrderTraversalSolution();
        System.out.println(BTZLO.zigzagLevelOrder(root));
    }
}
