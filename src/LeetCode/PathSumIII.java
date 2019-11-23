package LeetCode;
/*
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */

import java.util.ArrayList;
import java.util.List;

//自己写的时间空间效率不够
class PathSumIIISolution {
    //    private int ans = 0;
//    private List<TreeNode> Has = new ArrayList<>();
//
//    public int pathSum(TreeNode root, int sum) {
//        backtrack(root, sum, sum);
//        return ans;
//    }
//
//
//    private void backtrack(TreeNode root, int sum, int res) {
//        if (root == null) return;
//        if (res - root.val == 0) {
//            ans++;
////            System.out.println("ans= " + ans);
////            System.out.println("res= " + res + "   root.val= " + root.val);
//        }
//        if (root.left != null) {
//            backtrack(root.left, sum, res - root.val);
//            if (!Has.contains(root.left)) {
//                Has.add(root.left);
//                backtrack(root.left, sum, sum);
//            }
//        }
//        if (root.right != null) {
//            backtrack(root.right, sum, res - root.val);
//            if (!Has.contains(root.right)) {
//                Has.add(root.right);
//                backtrack(root.right, sum, sum);
//            }
//        }
//    }

    //别人写的真的很牛逼。。。
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return backtrack(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int backtrack(TreeNode root, int sum) {
        if (root == null) return 0;
        return (root.val == sum ? 1 : 0) + backtrack(root.left, sum - root.val) + backtrack(root.right, sum - root.val);
    }
}

public class PathSumIII {
    public static void main(String[] args) {
        String[] nodes = {"10", "5", "-3", "3", "2", "null", "11", "3", "-2", "null", "1"};
        int sum = 8;
//        String[] nodes = {"1", "null", "2", "null", "3", "null", "4", "null", "5"};
//        int sum = 3;
        BuildTree buildTree = new BuildTree();
        TreeNode root = buildTree.LevelBuild(nodes);
        PathSumIIISolution pathSumIIISolution = new PathSumIIISolution();
        System.out.println(pathSumIIISolution.pathSum(root, sum));
    }
}
