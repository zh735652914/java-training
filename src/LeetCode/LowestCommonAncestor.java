package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]




Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.
 */
class LowestCommonAncestorSolution {
    private List<TreeNode> PAncestor = new ArrayList<>();
    private List<TreeNode> QAncestor = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        backtrack(root, p, true);
        backtrack(root, q, false);
        TreeNode ans = null;
        int pIndex = PAncestor.size() - 1, qIndex = QAncestor.size() - 1;
        for (; pIndex >= 0 && qIndex >= 0; pIndex--, qIndex--) {
            if (PAncestor.get(pIndex) != QAncestor.get(qIndex)) {
                ans = PAncestor.get(pIndex + 1);
                break;
            }
        }
        if (ans == null) {
            ans = pIndex < 0 ? p : q;
        }
        return ans;
    }

    private boolean backtrack(TreeNode root, TreeNode x, boolean Left) {
        if (root == null) return false;
        if (root == x) {
            if (Left) {
                PAncestor.add(root);
            } else {
                QAncestor.add(root);
            }
            return true;
        }
        boolean has = backtrack(root.left, x, Left) || backtrack(root.right, x, Left);
        if (has) {
            if (Left) {
                PAncestor.add(root);
            } else {
                QAncestor.add(root);
            }
        }
        return has;
    }
}

public class LowestCommonAncestor {
    public static void main(String[] args) {
        String[] nodes = {"3", "5", "1", "6", "2", "0", "8", "null", "null", "7", "4"};
        BuildTree buildTree = new BuildTree();
        TreeNode root = buildTree.LevelBuild(nodes);
        LowestCommonAncestorSolution lowestCommonAncestorSolution = new LowestCommonAncestorSolution();
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        int pVal = 6;
        int qVal = 0;
        TreeNode p = lowestCommonAncestor.findNode(pVal, root);
        TreeNode q = lowestCommonAncestor.findNode(qVal, root);
        TreeNode ans = lowestCommonAncestorSolution.lowestCommonAncestor(root, p, q);
        System.out.println(ans.val);
    }

    private TreeNode findNode(int val, TreeNode root) {
        if (root == null) return root;
        if (root.val == val) return root;
        TreeNode node;
        node = findNode(val, root.left);
        if (node == null) {
            node = findNode(val, root.right);
        }
        return node;
    }
}
