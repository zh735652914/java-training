package LeetCode;
/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
//不会写...
//不是自己写的动态规划，感觉自己真的很垃圾，参考https://leetcode.wang/leetCode-95-Unique-Binary-Search-TreesII.html#%E8%A7%A3%E6%B3%95%E4%B8%89-%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92

import java.util.ArrayList;
import java.util.List;

class UniqueBinarySearchTreesIISolution {
    public List<TreeNode> generateTrees(int n) {
//        List<TreeNode>[] ans = new ArrayList[n + 1];
        List<TreeNode>[] ans = new List[n + 1];
        ans[0] = new ArrayList<TreeNode>();
        if (n == 0) return ans[0];
        ans[0].add(null);
        for (int len = 1; len <= n; len++) {
            ans[len] = new ArrayList<TreeNode>();
            for (int i = 0; i < len; i++) {
                for (TreeNode nodeL : ans[i]) {
                    for (TreeNode nodeR : ans[len - i - 1]) {
                        TreeNode node = new TreeNode(i + 1);
                        node.left = nodeL;
                        node.right = clone(nodeR, i + 1);
                        ans[len].add(node);
                    }
                }
            }
        }
        return ans[n];
    }

    private static TreeNode clone(TreeNode root, int offset) {
        if (root == null) return root;
        TreeNode node = new TreeNode(root.val + offset);
        node.left = clone(root.left, offset);
        node.right = clone(root.right, offset);
        return node;
    }
}


public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        int n = 3;
        UniqueBinarySearchTreesIISolution UBSTII = new UniqueBinarySearchTreesIISolution();
        List<TreeNode> ans = UBSTII.generateTrees(n);
        System.out.println(ans);
    }
}
